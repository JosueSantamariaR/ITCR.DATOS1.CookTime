using System;
using CookTime.Views.Forms;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace CookTime
{
    public partial class App : Application
    {
        public static string BaseImageUrl { get; } = "https://cdn.syncfusion.com/essential-ui-kit-for-xamarin.forms/common/uikitimages/";
        public App()
        {
            //Register Syncfusion license
            Syncfusion.Licensing.SyncfusionLicenseProvider.RegisterLicense("Mjc5MTI1QDMxMzgyZTMxMmUzMEFSY3FKOGVFcGVZYUZJSW1qazJVSWFnRUtIZHRML2hGM3JjRGFORFlkOEE9");
            
            InitializeComponent();
            
            SimpleLoginPage login = new SimpleLoginPage();

            MainPage = new NavigationPage(login);
        }

        protected override void OnStart()
        {
        }

        protected override void OnSleep()
        {
        }

        protected override void OnResume()
        {
        }
    }
}
