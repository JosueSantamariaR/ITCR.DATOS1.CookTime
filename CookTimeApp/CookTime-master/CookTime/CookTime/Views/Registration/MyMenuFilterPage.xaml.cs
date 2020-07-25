using CookTime.ViewModels;
using CookTime.Views.Catalog;
using Newtonsoft.Json;
using System;
using System.Net.Http;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Forms
{
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class MyMenuFilterPage : ContentPage
    {
        public MyMenuFilterPage()
        {
            InitializeComponent();
        }

       static string filter; 
       private async void Filter_Clicked(object sender, System.EventArgs e)
        {
            filter = chooseSearch.Text;
            if ( string.IsNullOrEmpty(chooseSearch.Text))
            {
                await this.DisplayAlert("alerta", "Debe selecionar un filtro", "ok");
                
            }
            else
            {
                await Navigation.PushAsync(new MyMenuSearchRecipePage());
            }
        }
        public  string getFilter()
        {
            return filter;
        }
       
    }
}