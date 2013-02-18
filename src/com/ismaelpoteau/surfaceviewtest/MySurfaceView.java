package com.ismaelpoteau.surfaceviewtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements Callback
{
	Bitmap mBitmap;
	SurfaceHolder holder;
	MyThread mThread;
	
	public MySurfaceView(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
	}
	public MySurfaceView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.terry); 
		holder = getHolder();
		holder.addCallback(this);
	}
	public MySurfaceView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height)
	{
		// TODO Auto-generated method stub

	}
	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		mThread = new MyThread(holder, getContext(),this);
		mThread.setRunning(true);
		mThread.start();
		// TODO Auto-generated method stub
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		mThread.setRunning(false);
		boolean retry = true;
		while(retry)
		{
			try
			{
				mThread.join();
				retry = false;
			}
			catch(Exception e)
			{
				Log.v("Exception Occured", e.getMessage());
			}
		}
	}

	void doDraw(Canvas canvas)
	{
		Rect dst = new Rect();
		dst.set(90, 120, 620 , 1040);
		Paint paint = new Paint();
		paint.setColor(Color.rgb(0, 0, 0));
		canvas.drawPaint(paint);
		canvas.drawBitmap(mBitmap, null, dst, null);
		paint.setColor(Color.rgb(255, 255, 255));
		paint.setTextSize(40);
		canvas.drawText("Yo Terry Check This out.", 10, 40, paint);
		
	}
}



