List of Errors:
 - Impl: getInputForAttr permission denied: recording not allowed for uid 10037 pid 974
 - at aezw.run(:com.google.android.gms@17785040@17.7.85 (100700-253824076):5)
 - at agkc.b(:com.google.android.gms@17785040@17.7.85 (100700-253824076):6)
 - at android.app.Activity.performCreate(Activity.java:7127)
 - at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1808) 
 - at android.app.ActivityThread.handleDispatchPackageBroadcast(ActivityThread.java:5388)
 - at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3048)
 - at android.app.ActivityThread.main(ActivityThread.java:6669)
 - at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2893)
 - at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2913)
 - at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1271)
 - at android.app.LoadedApk.createAppFactory(LoadedApk.java:226)
 - at android.app.LoadedApk.updateApplicationInfo(LoadedApk.java:338)
 - at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:78) 
 - at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68)
 - at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:68) 
 - at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:108)
 - at android.os.Handler.dispatchMessage(Handler.java:106)
 - at android.os.Looper.loop(Looper.java:193) 
 - at aodk.a(:com.google.android.gms@17785040@17.7.85 (100700-253824076):19)
 - at aodk.a(:com.google.android.gms@17785040@17.7.85 (100700-253824076):2)
 - at aodk.a(:com.google.android.gms@17785040@17.7.85 (100700-253824076):31)
 - at avgq.a(:com.google.android.gms@17785040@17.7.85 (100700-253824076):18)
 - at awkp.a(:com.google.android.gms@17785040@17.7.85 (100700-253824076):43)
 - at cdky.c(:com.google.android.gms@17785040@17.7.85 (100700-253824076):3)
 - at cdmp.b(:com.google.android.gms@17785040@17.7.85 (100700-253824076):14)
 - at cdub.<init>(:com.google.android.gms@17785040@17.7.85 (100700-253824076):2)
 - at cdue.<init>(:com.google.android.gms@17785040@17.7.85 (100700-253824076):1)
 - at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:493) 
 - at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:858) 
 - at com.android.server.SystemServer.main(SystemServer.java:294)
 - at com.android.server.SystemServer.run(SystemServer.java:454)
 - at com.google.android.chimera.IntentOperation.onHandleIntent(:com.google.android.gms@17785040@17.7.85 (100700-253824076):2)
 - at com.google.android.gms.clearcut.uploader.QosUploaderChimeraService.a(:com.google.android.gms@17785040@17.7.85 (100700-253824076):28)
 - at com.google.android.gms.clearcut.uploader.QosUploaderChimeraService.a(:com.google.android.gms@17785040@17.7.85 (100700-253824076):9)
 - at com.google.android.gms.udc.service.UdcContextInitChimeraService.a(:com.google.android.gms@17785040@17.7.85 (100700-253824076):127)
 - at com.google.android.libraries.matchstick.net.SilentRegisterIntentOperation.a(:com.google.android.gms@17785040@17.7.85 (100700-253824076):111)
 - at com.google.android.libraries.matchstick.net.SilentRegisterIntentOperation.a(:com.google.android.gms@17785040@17.7.85 (100700-253824076):146)
 - at com.google.android.libraries.matchstick.net.SilentRegisterIntentOperation.a(:com.google.android.gms@17785040@17.7.85 (100700-253824076):318)
 - at com.google.android.libraries.matchstick.net.SilentRegisterIntentOperation.onHandleIntent(:com.google.android.gms@17785040@17.7.85 (100700-253824076):81)
 - at com.google.android.libraries.matchstick.net.SilentRegisterIntentOperation.onHandleIntent(:com.google.android.gms@17785040@17.7.85 (100700-253824076):81)
 - at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:134)
 - at edu.cnm.deepdive.beer_buddy.controller.MainActivity.onCreate(MainActivity.java:40)
 - at edu.cnm.deepdive.beer_buddy.controller.MainActivity.setupSearch(MainActivity.java:96)
 - at eej.run(:com.google.android.gms@17785040@17.7.85 (100700-253824076):10)
 - at java.lang.ClassLoader.loadClass(ClassLoader.java:379)
 - at java.lang.reflect.Method.invoke(Native Method) 
 - at java.lang.Thread.run(Thread.java:764)
 - at java.util.concurrent.CountDownLatch.await(CountDownLatch.java:278)
 - at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedNanos(AbstractQueuedSynchronizer.java:1063)
 - at java.util.concurrent.locks.AbstractQueuedSynchronizer.tryAcquireSharedNanos(AbstractQueuedSynchronizer.java:1352)
 - at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
 - at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
 - at qgf.onHandleIntent(:com.google.android.gms@17785040@17.7.85 (100700-253824076):4)
 - at sda.a(:com.google.android.gms@17785040@17.7.85 (100700-253824076):42)
 - at sqo.run(Unknown Source:7)
 - Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.
 - Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'android.view.View android.view.View.findViewById(int)' on a null object reference
 - Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.Button.setOnClickListener(android.view.View$OnClickListener)' on a null object reference
 - Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.ImageButton.setOnClickListener(android.view.View$OnClickListener)' on a null object reference
 - Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.ListView.setOnClickListener(android.view.View$OnClickListener)' on a null object reference
 - cdlc: PERMISSION_DENIED: The caller does not have permission
 - java.lang.ClassNotFoundException: Didn't find class "androidx.core.app.CoreComponentFactory" on path: DexPathList[[],nativeLibraryDirectories=[/data/app/edu.cnm.deepdive.beer_buddy-j9tMm1NuHUbz5W-4JlDmFg==/lib/x86, /system/lib]]
 - java.lang.InterruptedException
 - java.lang.RuntimeException: ManagedChannel allocation site
 - java.lang.RuntimeException: Unable to start activity ComponentInfo{edu.cnm.deepdive.beer_buddy/edu.cnm.deepdive.beer_buddy.controller.MainActivity}: java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.ListView.setOnClickListener(android.view.View$OnClickListener)' on a null object reference
 - Process: edu.cnm.deepdive.beer_buddy, PID: 9965
 - 2019-07-22 11:22:41.623 1633-1698/? E/AudioFlinger: createRecord() checkRecordThread_l failed
 - 2019-07-22 15:37:00.300 1887-1900/? E/memtrack: Couldn't load memtrack module
 - 2019-07-22 15:37:04.998 1633-1698/? E/AudioFlinger: createRecord() checkRecordThread_l failed
 - 2019-07-22 15:43:27.408 1633-1698/? E/AudioPolicyIntefaceImpl: getInputForAttr permission denied: recording not allowed for uid 10037 pid 974
 - 2019-07-22 15:43:27.409 974-13415/? E/android.media.AudioRecord: Error code -20 when initializing native AudioRecord object.
 - 2019-07-22 15:43:27.409 974-13415/? E/AudioRecord: AudioFlinger could not create record track, status: -22
 - 2019-07-22 15:43:27.409 974-13415/? E/AudioRecord-JNI: Error creating AudioRecord instance: initialization check failed with status -22.
 - 2019-07-22 15:43:27.409 974-13415/? E/IAudioFlinger: createRecord returned error -22