### List of Errors:

2019-07-23 06:31:12.560 1887-1887/? E/LoadedApk: Unable to instantiate appComponentFactory
    java.lang.ClassNotFoundException: Didn't find class "androidx.core.app.CoreComponentFactory" on path: DexPathList[[],nativeLibraryDirectories=[/data/app/edu.cnm.deepdive.beer_buddy-j9tMm1NuHUbz5W-4JlDmFg==/lib/x86, /system/lib]]
        at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:134)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:379)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:312)
        at android.app.LoadedApk.createAppFactory(LoadedApk.java:226)
        at android.app.LoadedApk.updateApplicationInfo(LoadedApk.java:338)
        at android.app.ActivityThread.handleDispatchPackageBroadcast(ActivityThread.java:5388)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1733)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:193)
        at com.android.server.SystemServer.run(SystemServer.java:454)
        at com.android.server.SystemServer.main(SystemServer.java:294)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:493)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:838)
2019-07-23 06:31:40.340 26137-26137/edu.cnm.deepdive.beer_buddy E/AndroidRuntime: FATAL EXCEPTION: main
    Process: edu.cnm.deepdive.beer_buddy, PID: 26137
    java.lang.NullPointerException: Attempt to invoke virtual method 'android.view.View android.widget.EditText.findViewById(int)' on a null object reference
        at edu.cnm.deepdive.beer_buddy.model.fragments.HappyHourFragment.setUpHappyHour(HappyHourFragment.java:55)
        at edu.cnm.deepdive.beer_buddy.model.fragments.HappyHourFragment.onCreate(HappyHourFragment.java:41)
        at androidx.fragment.app.Fragment.performCreate(Fragment.java:2581)
        at androidx.fragment.app.FragmentManagerImpl.moveToState(FragmentManagerImpl.java:838)
        at androidx.fragment.app.FragmentTransition.addToFirstInLastOut(FragmentTransition.java:1197)
        at androidx.fragment.app.FragmentTransition.calculateFragments(FragmentTransition.java:1080)
        at androidx.fragment.app.FragmentTransition.startTransitions(FragmentTransition.java:119)
        at androidx.fragment.app.FragmentManagerImpl.executeOpsTogether(FragmentManagerImpl.java:1863)
        at androidx.fragment.app.FragmentManagerImpl.removeRedundantOperationsAndExecute(FragmentManagerImpl.java:1821)
        at androidx.fragment.app.FragmentManagerImpl.execPendingActions(FragmentManagerImpl.java:1727)
        at androidx.fragment.app.FragmentManagerImpl$2.run(FragmentManagerImpl.java:150)
        at android.os.Handler.handleCallback(Handler.java:873)
        at android.os.Handler.dispatchMessage(Handler.java:99)
        at android.os.Looper.loop(Looper.java:193)
        at android.app.ActivityThread.main(ActivityThread.java:6669)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:493)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:858)
