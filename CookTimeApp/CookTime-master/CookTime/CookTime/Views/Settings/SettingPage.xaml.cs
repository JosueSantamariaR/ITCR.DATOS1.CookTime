using CookTime.Views.Bookmarks;
using CookTime.Views.Forms;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Settings
{
    /// <summary>
    /// Page to show the setting.
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class SettingPage : ContentPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="SettingPage" /> class.
        /// </summary>
        public SettingPage()
        {
            InitializeComponent();
        }

        private async void backButton_Clicked(object sender, System.EventArgs e)
        {
            await Navigation.PopAsync();
        }

 

        private async void LogOutSettingsButton_Clicked(object sender, System.EventArgs e)
        {
            await Navigation.PopToRootAsync();
        }

        private async void AddNewEnterprise_Clicked(object sender, System.EventArgs e)
        {
            await Navigation.PushAsync(new AddProfilePage());
        }
    }
}