using CookTime.Views.Bookmarks;
using CookTime.Views.Forms;
using CookTime.Views.Navigation;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Social
{
    /// <summary>
    /// Page to show the social profile.
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class SocialProfileWithMessagePage : ContentPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="SocialProfileWithMessagePage" /> class.
        /// </summary>
        public SocialProfileWithMessagePage()
        {
            InitializeComponent();
        }

        private async void SettingsButton_Clicked(object sender, System.EventArgs e)
        {
            await Navigation.PushAsync(new Settings.SettingPage());
        }

        private async void MyMenuButton_Clicked(object sender, System.EventArgs e)
        {
            await Navigation.PushAsync(new MyMenuFilterPage());
        }
    }
}