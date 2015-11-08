package physics.com.physics.util;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by bruno on 07/11/15.
 */
public interface TabChangeListener {
    void fragmentBecameVisible(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
}
