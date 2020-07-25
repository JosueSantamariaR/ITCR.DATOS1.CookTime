using CookTime.ViewModels;
using CookTime.ViewModels.News;
using CookTime.ViewModels.Social;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Social
{
    /// <summary>
    /// Page to show the social profile with interests page.
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class SearchProfileDetailPage : ContentPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="SocialProfileWithInterestsPage" /> class.
        /// </summary>
        public SearchProfileDetailPage(User user)
        {
            InitializeComponent();
            BindingContext = new SocialProfileViewModel2(user);
        }
    }
}