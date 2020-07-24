package crc6466d27d713c291f37;


public class SfPopupLayout
	extends android.widget.RelativeLayout
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onKeyDown:(ILandroid/view/KeyEvent;)Z:GetOnKeyDown_ILandroid_view_KeyEvent_Handler\n" +
			"";
		mono.android.Runtime.register ("Syncfusion.XForms.Android.PopupLayout.SfPopupLayout, Syncfusion.SfPopupLayout.XForms.Android", SfPopupLayout.class, __md_methods);
	}


	public SfPopupLayout (android.content.Context p0)
	{
		super (p0);
		if (getClass () == SfPopupLayout.class)
			mono.android.TypeManager.Activate ("Syncfusion.XForms.Android.PopupLayout.SfPopupLayout, Syncfusion.SfPopupLayout.XForms.Android", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public SfPopupLayout (android.content.Context p0, android.util.AttributeSet p1)
	{
		super (p0, p1);
		if (getClass () == SfPopupLayout.class)
			mono.android.TypeManager.Activate ("Syncfusion.XForms.Android.PopupLayout.SfPopupLayout, Syncfusion.SfPopupLayout.XForms.Android", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public SfPopupLayout (android.content.Context p0, android.util.AttributeSet p1, int p2)
	{
		super (p0, p1, p2);
		if (getClass () == SfPopupLayout.class)
			mono.android.TypeManager.Activate ("Syncfusion.XForms.Android.PopupLayout.SfPopupLayout, Syncfusion.SfPopupLayout.XForms.Android", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public SfPopupLayout (android.content.Context p0, android.util.AttributeSet p1, int p2, int p3)
	{
		super (p0, p1, p2, p3);
		if (getClass () == SfPopupLayout.class)
			mono.android.TypeManager.Activate ("Syncfusion.XForms.Android.PopupLayout.SfPopupLayout, Syncfusion.SfPopupLayout.XForms.Android", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public boolean onKeyDown (int p0, android.view.KeyEvent p1)
	{
		return n_onKeyDown (p0, p1);
	}

	private native boolean n_onKeyDown (int p0, android.view.KeyEvent p1);

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
