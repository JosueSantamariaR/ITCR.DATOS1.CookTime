using CookTime.ViewModels.Catalog;
using CookTime.ViewModels.Detail;
using CookTime.ViewModels.News;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Detail
{
    /// <summary>
    /// Article detail page.
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class SearchRecipeDetailPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="T:CookTime.Views.Detail.SearchRecipeDetailPage"/> class.
        /// </summary>
        public SearchRecipeDetailPage(Recet recet)
        {
            InitializeComponent();
            BindingContext = new SearchRecipeDetailPageViewModel(recet);
        }
    }
}