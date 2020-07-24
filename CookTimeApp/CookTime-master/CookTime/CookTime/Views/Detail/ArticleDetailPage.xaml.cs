using CookTime.ViewModels.Detail;
using CookTime.ViewModels.News;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Detail
{
    /// <summary>
    /// Article detail page.
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class ArticleDetailPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="T:CookTime.Views.Detail.ArticleDetailPage"/> class.
        /// </summary>
        public ArticleDetailPage(Recet recet)
        {
            InitializeComponent();
            BindingContext = new ArticleDetailPageViewModel(recet);
        }
    }
}