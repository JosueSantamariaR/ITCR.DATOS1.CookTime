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
    public partial class NewsFeedDetailPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="T:CookTime.Views.Detail.NewsFeedDetailPage"/> class.
        /// </summary>
        public NewsFeedDetailPage(Recet recet)
        {
            InitializeComponent();
            BindingContext = new NewsFeedDetailPageViewModel(recet);
        }
    }
}