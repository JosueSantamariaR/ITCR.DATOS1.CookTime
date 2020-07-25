using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Templates
{
    /// <summary>
    /// Article list template.
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class UserSearchMyMenuTemplate : Grid
    {
        /// <summary>
        /// Bindable property to set the parent bindingcontext.
        /// </summary>
        public static BindableProperty ParentBindingContextProperty =
         BindableProperty.Create(nameof(ParentBindingContext), typeof(object),
         typeof(UserSearchMyMenuTemplate), null);

        /// <summary>
        /// Gets or sets the parent bindingcontext.
        /// </summary>
        public object ParentBindingContext
        {
            get { return GetValue(ParentBindingContextProperty); }
            set { SetValue(ParentBindingContextProperty, value); }
        }



        /// <summary>
        /// Initializes a new instance of the <see cref="ArticleListTemplate"/> class.
        /// </summary>
		public UserSearchMyMenuTemplate()
        {
            InitializeComponent();
        }
    }
}