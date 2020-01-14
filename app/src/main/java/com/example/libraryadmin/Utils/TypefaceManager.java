package com.example.libraryadmin.Utils;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.LruCache;

public class TypefaceManager {

    public static final String PYIDAUNGSU = "pyidaungsu.ttf";
    public static final String ZAWGYIONE = "zawgyi_one.ttf";
    public static final String PASSCODEFONT = "Font-Regular.ttf";
    public static final String ROBOTO = "roboto.ttf";
    public static final String DIGIT = "digit.ttf";
    public static final String MYANMAR_SAGAR = "myanmar_sagar.ttf";
    private final AssetManager manager;

    private final LruCache<String, Typeface> mCache;

    public TypefaceManager(AssetManager manager) {
        this.manager = manager;
        int cacheSize = 4 * 1024 * 1024;
        mCache = new LruCache<>(cacheSize);
    }

    public Typeface getShitUnicode() { return getTypeface(PYIDAUNGSU); }
    public Typeface getShitZawgyi() {
        return getTypeface(ZAWGYIONE);
    }
    public Typeface getDigitFont() {
        return getTypeface(DIGIT);
    }
    public Typeface getPasscodeFont() {
        return getTypeface(PASSCODEFONT);
    }
    public Typeface getRobotoFont() {
        return getTypeface(ROBOTO);
    }
    public Typeface getMyanmarSagar() { return getTypeface(MYANMAR_SAGAR); }

    public Typeface getTypeface(final String filename) {
        Typeface typeface = mCache.get(filename);
        if(typeface == null) {
            typeface = Typeface.createFromAsset(manager, filename);
        }
        return typeface;
    }
}
