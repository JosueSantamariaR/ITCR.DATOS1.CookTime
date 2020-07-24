package crc64d478ed32b2f14986;


public class SfRichTextEditorRendererExt
	extends crc643f46942d9dd1fff9.ViewRenderer_2
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreateContextMenu:(Landroid/view/ContextMenu;)V:GetOnCreateContextMenu_Landroid_view_ContextMenu_Handler\n" +
			"";
		mono.android.Runtime.register ("Syncfusion.XForms.Android.RichTextEditor.SfRichTextEditorRendererExt, Syncfusion.SfRichTextEditor.XForms.Android", SfRichTextEditorRendererExt.class, __md_methods);
	}


	public SfRichTextEditorRendererExt (android.content.Context p0, android.util.AttributeSet p1, int p2)
	{
		super (p0, p1, p2);
		if (getClass () == SfRichTextEditorRendererExt.class)
			mono.android.TypeManager.Activate ("Syncfusion.XForms.Android.RichTextEditor.SfRichTextEditorRendererExt, Syncfusion.SfRichTextEditor.XForms.Android", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public SfRichTextEditorRendererExt (android.content.Context p0, android.util.AttributeSet p1)
	{
		super (p0, p1);
		if (getClass () == SfRichTextEditorRendererExt.class)
			mono.android.TypeManager.Activate ("Syncfusion.XForms.Android.RichTextEditor.SfRichTextEditorRendererExt, Syncfusion.SfRichTextEditor.XForms.Android", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public SfRichTextEditorRendererExt (android.content.Context p0)
	{
		super (p0);
		if (getClass () == SfRichTextEditorRendererExt.class)
			mono.android.TypeManager.Activate ("Syncfusion.XForms.Android.RichTextEditor.SfRichTextEditorRendererExt, Syncfusion.SfRichTextEditor.XForms.Android", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public void onCreateContextMenu (android.view.ContextMenu p0)
	{
		n_onCreateContextMenu (p0);
	}

	private native void n_onCreateContextMenu (android.view.ContextMenu p0);

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
