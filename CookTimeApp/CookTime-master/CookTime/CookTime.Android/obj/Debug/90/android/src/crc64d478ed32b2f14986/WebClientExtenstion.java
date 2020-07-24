package crc64d478ed32b2f14986;


public class WebClientExtenstion
	extends android.webkit.WebChromeClient
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onProgressChanged:(Landroid/webkit/WebView;I)V:GetOnProgressChanged_Landroid_webkit_WebView_IHandler\n" +
			"";
		mono.android.Runtime.register ("Syncfusion.XForms.Android.RichTextEditor.WebClientExtenstion, Syncfusion.SfRichTextEditor.XForms.Android", WebClientExtenstion.class, __md_methods);
	}


	public WebClientExtenstion ()
	{
		super ();
		if (getClass () == WebClientExtenstion.class)
			mono.android.TypeManager.Activate ("Syncfusion.XForms.Android.RichTextEditor.WebClientExtenstion, Syncfusion.SfRichTextEditor.XForms.Android", "", this, new java.lang.Object[] {  });
	}


	public void onProgressChanged (android.webkit.WebView p0, int p1)
	{
		n_onProgressChanged (p0, p1);
	}

	private native void n_onProgressChanged (android.webkit.WebView p0, int p1);

	private java.util.ArrayList refList;
	public void monodroidAddReference (java.lang.Object obj)
	{
		if (refList == null)
			refList = new java.util.ArrayList ();
		refList.add (obj);
	}

	public void monodroidClearReferences ()
	{
		if (refList != null)
			refList.clear ();
	}
}
