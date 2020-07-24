using CookTime.DataService;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Notification
{
    /// <summary>
    /// Page to show the health care details.
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class SocialNotificationPage : ContentPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="SocialNotificationPage" /> class.
        /// </summary>
        public SocialNotificationPage()
        {
            InitializeComponent();
            this.BindingContext = NotificationsDataService.Instance.SocialNotificationViewModel;
        }
    }
}
