package com.example.student.alarmclock;

/**
 * Created by student on 5/8/16.
 */

        import android.app.Activity;
        import android.content.ComponentName;
        import android.content.Context;
        import android.content.Intent;
        import android.media.MediaPlayer;
        import android.media.Ringtone;
        import android.media.RingtoneManager;
        import android.net.Uri;
        import android.support.v4.content.WakefulBroadcastReceiver;

        import java.io.IOException;

public class AlarmReceiver extends WakefulBroadcastReceiver {

    MediaPlayer newPlayer=new MediaPlayer();
    @Override
    public void onReceive(final Context context, Intent intent) {
        //this will update the UI with message
        AlarmActivity inst = AlarmActivity.instance();
        inst.setAlarmText("Alarm! Wake up! Wake up!");

        //this will sound the alarm tone
        //this will sound the alarm once, if you wish to
        //raise alarm in loop continuously then use MediaPlayer and setLooping(true)
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
       // Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
       // ringtone.play();


       // newPlayer = new MediaPlayer();
        try {
            newPlayer.setDataSource(context,alarmUri);
            newPlayer.prepare();
            newPlayer.setLooping(true);
            newPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //this will send a notification message
        ComponentName comp = new ComponentName(context.getPackageName(),
                AlarmService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
    }

}