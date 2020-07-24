package crc64d478ed32b2f14986;


public class JSBridge
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_InvokeAction:(Ljava/lang/String;)V:__export__\n" +
			"n_InvokeText:(Ljava/lang/String;)V:__export__\n" +
			"n_InvokeHmtlText:(Ljava/lang/String;)V:__export__\n" +
			"n_InvokeSelectedText:(Ljava/lang/String;)V:__export__\n" +
			"n_InvokeHyperLink:(Ljava/lang/String;)V:__export__\n" +
			"n_InvokeTitleText:(Ljava/lang/String;)V:__export__\n" +
			"n_InvokeFormatChange:(Ljava/lang/String;)V:__export__\n" +
			"n_InvokeHyperlinkEvent:()V:__export__\n" +
			"n_InvokeScrollHeightChange:(Ljava/lang/String;)V:__export__\n" +
			"";
		mono.android.Runtime.register ("Syncfusion.XForms.Android.RichTextEditor.JSBridge, Syncfusion.SfRichTextEditor.XForms.Android", JSBridge.class, __md_methods);
	}


	public JSBridge ()
	{
		super ();
		if (getClass () == JSBridge.class)
			mono.android.TypeManager.Activate ("Syncfusion.XForms.Android.RichTextEditor.JSBridge, Syncfusion.SfRichTextEditor.XForms.Android", "", this, new java.lang.Object[] {  });
	}

	public JSBridge (crc64d478ed32b2f14986.SfRichTextEditorRendererExt p0)
	{
		super ();
		if (getClass () == JSBridge.class)
			mono.android.TypeManager.Activate ("Syncfusion.XForms.Android.RichTextEditor.JSBridge, Syncfusion.SfRichTextEditor.XForms.Android", "Syncfusion.XForms.Android.RichTextEditor.SfRichTextEditorRendererExt, Syncfusion.SfRichTextEditor.XForms.Android", this, new java.lang.Object[] { p0 });
	}

	@android.webkit.JavascriptInterface

	public void invokeAction (java.lang.String p0)
	{
		n_InvokeAction (p0);
	}

	private native void n_InvokeAction (java.lang.String p0);

	@android.webkit.JavascriptInterface

	public void invokeText (java.lang.String p0)
	{
		n_InvokeText (p0);
	}

	private native void n_InvokeText (java.lang.String p0);

	@android.webkit.JavascriptInterface

	public void invokeHtmlText (java.lang.String p0)
	{
		n_InvokeHmtlText (p0);
	}

	private native void n_InvokeHmtlText (java.lang.String p0);

	@android.webkit.JavascriptInterface

	public void invokeSelectedText (java.lang.String p0)
	{
		n_InvokeSelectedText (p0);
	}

	private native void n_InvokeSelectedText (java.lang.String p0);

	@android.webkit.JavascriptInterface

	public void invokeHyperLink (java.lang.String p0)
	{
		n_InvokeHyperLink (p0);
	}

	private native void n_InvokeHyperLink (java.lang.String p0);

	@android.webkit.JavascriptInterface

	public void invokeTitleText (java.lang.String p0)
	{
		n_InvokeTitleText (p0);
	}

	private native void n_InvokeTitleText (java.lang.String p0);

	@android.webkit.JavascriptInterface

	public void invokeFormatChange (java.lang.String p0)
	{
		n_InvokeFormatChange (p0);
	}

	private native void n_InvokeFormatChange (java.lang.String p0);

	@android.webkit.JavascriptInterface

	public void invokeHyperlinkEvent ()
	{
		n_InvokeHyperlinkEvent ();
	}

	private native void n_InvokeHyperlinkEvent ();

	@android.webkit.JavascriptInterface

	public void invokeScrollHeightChange (java.lang.String p0)
	{
		n_InvokeScrollHeightChange (p0);
	}

	private native void n_InvokeScrollHeightChange (java.lang.String p0);

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
