package com.ismaelpoteau.surfaceviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

class MyThread extends Thread
{
	boolean runIt;
	Canvas mCanvas;
	Context mContext;
	SurfaceHolder mSurfaceHolder;
	MySurfaceView mSurfaceView;
	
	public MyThread(SurfaceHolder sholder, Context ctx, MySurfaceView panelView )
	{
		runIt = false;
		mContext = ctx;
		mSurfaceHolder = sholder;
		mSurfaceView = panelView;
	}
	void setRunning(boolean toRun)
	{
		runIt = toRun;
	}
	public void run()
	{
		super.run();
		while(runIt)
		{
			mCanvas = mSurfaceHolder.lockCanvas();
			if( mCanvas != null )
			{
				mSurfaceView.doDraw(mCanvas);
				mSurfaceHolder.unlockCanvasAndPost(mCanvas);
			}
		}
	}
	public MyThread()
	{
		// TODO Auto-generated constructor stub
	}

	public MyThread(Runnable runnable)
	{
		super(runnable);
		// TODO Auto-generated constructor stub
	}

	public MyThread(String threadName)
	{
		super(threadName);
		// TODO Auto-generated constructor stub
	}

	public MyThread(Runnable runnable, String threadName)
	{
		super(runnable, threadName);
		// TODO Auto-generated constructor stub
	}

	public MyThread(ThreadGroup group, Runnable runnable)
	{
		super(group, runnable);
		// TODO Auto-generated constructor stub
	}

	public MyThread(ThreadGroup group, String threadName)
	{
		super(group, threadName);
		// TODO Auto-generated constructor stub
	}

	public MyThread(ThreadGroup group, Runnable runnable, String threadName)
	{
		super(group, runnable, threadName);
		// TODO Auto-generated constructor stub
	}

	public MyThread(ThreadGroup group, Runnable runnable, String threadName,
			long stackSize)
	{
		super(group, runnable, threadName, stackSize);
		// TODO Auto-generated constructor stub
	}

}