package auth.example.andy.navigation;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import auth.example.andy.navigation_poc.R;
import auth.example.andy.navigation_poc.actionDashboard;
import auth.example.andy.navigation_poc.actionHome;
import auth.example.andy.navigation_poc.actionNotifications;
import auth.example.andy.navigation_poc.actionNotificationsDirections;
import auth.example.andy.navigation_poc.notificationDetails;

/**
 * Refer: https://proandroiddev.com/android-navigation-arch-component-a-curious-investigation
 * -3e56e24126e1
 */
public class MainActivity extends AppCompatActivity implements actionHome
        .OnFragmentInteractionListener, actionNotifications.OnFragmentInteractionListener,
        actionDashboard.OnFragmentInteractionListener, notificationDetails.OnFragmentInteractionListener, NavController.OnDestinationChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        NavController navController = Navigation.findNavController(this, R.id
                .mainNavigationFragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController);

        navController.addOnDestinationChangedListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.mainNavigationFragment).navigateUp();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public void viewNotificationDetails(View view) {

        Navigation.findNavController(this, R.id.mainNavigationFragment).navigate(R.id.notificationDetails);

    }

    @Override
    public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
        Log.d("MAIN", "message");
    }

    public void viewProfile(View view) {

        NavDirections action = actionNotificationsDirections.actionActionNotificationsToViewProfile();
        Navigation.findNavController(this, R.id.mainNavigationFragment).navigate(action);
    }
}
