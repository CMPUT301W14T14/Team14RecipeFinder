package camera;

import java.io.File;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

public class Camera_Intent_Generator {
	
	public Camera_Intent_Generator(){}
	
	public Intent getCamIntent(){
		Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		String path=Environment.getExternalStorageDirectory().getAbsolutePath()+"/tmp";
		String date=String.valueOf(System.currentTimeMillis())+".jpeg";
		File filepic=new File(path+date);
		Uri imageFileUri=Uri.fromFile(filepic);
		intent.putExtra(MediaStore.EXTRA_OUTPUT,imageFileUri);
		return intent;
	}
}
// Adapted from https://github.com/baoliangwang/CameraDemo/blob/master/src/ualberta/cmput301/camerademo/CameraDemoActivity.java