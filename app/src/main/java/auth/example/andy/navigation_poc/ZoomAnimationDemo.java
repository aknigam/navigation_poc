package auth.example.andy.navigation_poc;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.navigation.Navigation;
import auth.example.andy.navigation.MainActivity;


public class ZoomAnimationDemo extends Fragment {



    private OnZoomInteractionListener mListener;

    public ZoomAnimationDemo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final View tv = getView().findViewById(R.id.thumb_button_1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomImageFromThumb(tv, R.drawable.fullimage);
            }
        });

        final View tv1 = getView().findViewById(R.id.thumb_button_2);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomAnimationDemoDirections.ActionZoomAnimationDemoToPincZoomImage action = ZoomAnimationDemoDirections.actionZoomAnimationDemoToPincZoomImage(R
                        .drawable.fullimage);
                Navigation.findNavController(getActivity(), R.id.mainNavigationFragment).navigate(action);
            }
        });



//        mImageView= getView().findViewById(R.id.imageView);
//        mScaleGestureDetector = new ScaleGestureDetector(this, new MainActivity.SimpleScaleListener());
        ((MainActivity)getActivity()).setUpZoomDetector((ImageView) getView().findViewById(R.id.imageView));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_zoom_animation_demo, container, false);
    }

    private void zoomImageFromThumb(View tv, int fullImage) {
        mListener.onZoom(tv, fullImage);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnZoomInteractionListener) {
            mListener = (OnZoomInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnZoomInteractionListener {

        void onZoom(View tv, int fullImage);
    }

}
