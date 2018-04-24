package com.aclessdev.WishTrackkr.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aclessdev.WishTrackkr.MainActivity;
import com.aclessdev.WishTrackkr.R;
import com.aclessdev.WishTrackkr.model.authentication.UserProfile;
import com.aclessdev.WishTrackkr.shared.BaseActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.Task;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.model.Birthday;
import com.google.api.services.people.v1.model.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.facebookLoginButton)
    LoginButton facebookLoginButton;

    CallbackManager callbackManager;
    @BindView(R.id.gmailLoginButton)
    SignInButton gmailLoginButton;

    GoogleSignInClient googleSignInClient;
    GoogleSignInOptions gso;


    String email;
    String birthday;
    String displayName;
    String profilePhotoUrl;
    String facebookId;

    static final int RC_SIGN_IN = 1607;

    public static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        
        if (appPreference.getUserProfile() == null){
            Toast.makeText(this, "Lom Login", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Dah login", Toast.LENGTH_SHORT).show();
            setupGoogleLogin();
        }


        
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount googleAccount = GoogleSignIn.getLastSignedInAccount(this);

    }

    private void setupGoogleLogin() {
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        // Build a GoogleSignInClient with the options specified by gso.
        googleSignInClient = GoogleSignIn.getClient(this,gso);

    }

    private void checkFacebookLogin() {
        callbackManager = CallbackManager.Factory.create();

        facebookLoginButton.setReadPermissions(Arrays.asList("public_profile", "email","user_birthday","user_friends"));
        facebookLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                if (loginResult.getRecentlyDeniedPermissions().size()>0){
                    Toast.makeText(LoginActivity.this, "All permissions must be grant to continue", Toast.LENGTH_SHORT).show();
                    LoginManager.getInstance().logOut();
                    facebookLoginButton.performClick();
                }else{
                    final String token = loginResult.getAccessToken().getToken();
                    GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response) {
                            try {
//                                Log.i(TAG, "onCompleted: "+object.toString(3));
                                facebookId = object.getString("id");
                                email = object.getString("email");
                                birthday = object.getString("birthday");
                                displayName = object.getString("name");
                                profilePhotoUrl = "https://graph.facebook.com/"+facebookId+"/picture?type=large";
                                UserProfile userProfile = new UserProfile(profilePhotoUrl,displayName,facebookId,email,birthday);
                                appPreference.setUserProfile(userProfile);

                                JSONArray jsonArrayFriends = object.getJSONObject("friends").getJSONArray("data");

//                                Log.i(TAG, "onCompleted: firends ;ength="+jsonArrayFriends.length());
//                                Log.i(TAG, "onCompleted: first friend name="+jsonArrayFriends.getJSONObject(0).getString("name"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    Bundle parameters = new Bundle();
                    //https://graph.facebook.com/user_id/picture?type=large
                    parameters.putString("fields","name,id, email,birthday,friends{email,id,name}");
                    request.setParameters(parameters);
                    request.executeAsync();
                }
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this, "cancel", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                error.printStackTrace();
                Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchUserProfile(String clientId) throws IOException {


        HttpTransport httpTransport = new NetHttpTransport();
        JacksonFactory jacksonFactory = new JacksonFactory();

//        GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport).setJsonFactory(jacksonFactory)
//                .setClientSecrets(R.string.clientId,).build().setFromTokenResponse()

//        PeopleService peopleService = new PeopleService.Builder(httpTransport,jacksonFactory);
//        Person userProfile = peopleService.people().get("people/me").execute();
//        List<Birthday> birthdays = userProfile.getBirthdays();
//        if (birthdays!=null && birthdays.size()>0){
//            birthday = birthdays.get(0).getText();
//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleGoogleLogin(task);
        }




    }

    private void handleGoogleLogin(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            //SETUP USER FROM GOOGLE SIGNIN
//            fetchUserProfile(account.getId());
            email = account.getEmail();
            displayName = account.getDisplayName();
            profilePhotoUrl = account.getPhotoUrl().toString();

        }catch (ApiException e){
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());

        }
    }


    @OnClick({R.id.gmailLoginButton, R.id.facebookLoginButton,R.id.btnLoginSkip})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gmailLoginButton:
                checkGmailLogin();
                break;
            case R.id.facebookLoginButton:
                checkFacebookLogin();
                break;
            case R.id.btnLoginSkip:
                Intent goMain = new Intent(this, MainActivity.class);
                startActivity(goMain);
                //SET PREFERENCE NOT LOGIN

        }
    }

    private void checkGmailLogin() {
        Intent loginGmailIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(loginGmailIntent,RC_SIGN_IN);
    }


}
