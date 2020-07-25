using CookTime.ViewModels.Catalog;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Catalog
{
    /// <summary>
    /// Page to list out article items.
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class UserSearchMyMenuPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="ArticleListPage" /> class.
        /// </summary>
        public UserSearchMyMenuPage()
        {
            InitializeComponent();
            BindingContext = new UserSearchMyMenuViewModel(Navigation);
        }
    }
}