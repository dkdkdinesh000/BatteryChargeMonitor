package batterymonitor.dev.com.batterchargemonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SharedPrefsUtils {
    @Nullable
    public static String getStringPreference(@NotNull Context context, @NotNull String key) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(key, "key");
        String value = (String)null;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences != null) {
            value = preferences.getString(key, (String)null);
        }

        return value;
    }

    public static boolean setStringPreference(@NotNull Context context, @NotNull String key, @NotNull String value) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences != null && !TextUtils.isEmpty((CharSequence)key)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(key, value);
            return editor.commit();
        } else {
            return false;
        }
    }

    public static boolean clearPreferences(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            return editor.commit();
        } else {
            return false;
        }
    }

    public static float getFloatPreference(@NotNull Context context, @NotNull String key, float defaultValue) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(key, "key");
        float value = defaultValue;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences != null) {
            value = preferences.getFloat(key, defaultValue);
        }

        return value;
    }

    public static boolean setFloatPreference(@NotNull Context context, @NotNull String key, float value) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putFloat(key, value);
            return editor.commit();
        } else {
            return false;
        }
    }

    public static long getLongPreference(@NotNull Context context, @NotNull String key, long defaultValue) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(key, "key");
        long value = defaultValue;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences != null) {
            value = preferences.getLong(key, defaultValue);
        }

        return value;
    }

    public static boolean setLongPreference(@NotNull Context context, @NotNull String key, long value) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putLong(key, value);
            return editor.commit();
        } else {
            return false;
        }
    }

    public static int getIntegerPreference(@NotNull Context context, @NotNull String key, int defaultValue) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(key, "key");
        int value = defaultValue;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences != null) {
            value = preferences.getInt(key, defaultValue);
        }

        return value;
    }

    public static boolean setIntegerPreference(@NotNull Context context, @NotNull String key, int value) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(key, value);
            return editor.commit();
        } else {
            return false;
        }
    }

    public static boolean getBooleanPreference(@NotNull Context context, @NotNull String key, boolean defaultValue) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(key, "key");
        boolean value = defaultValue;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences != null) {
            value = preferences.getBoolean(key, defaultValue);
        }

        return value;
    }

    public static boolean setBooleanPreference(@NotNull Context context, @NotNull String key, boolean value) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(key, "key");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(key, value);
            return editor.commit();
        } else {
            return false;
        }
    }

}