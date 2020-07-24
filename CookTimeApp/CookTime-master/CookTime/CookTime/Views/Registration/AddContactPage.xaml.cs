using CookTime.ViewModels;
using CookTime.ViewModels.News;
using CookTime.Views.Catalog;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Forms
{
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class AddContactPage : ContentPage
    {
        public AddContactPage()
        {
            InitializeComponent();
        }
       static string x ="no";
       static string search1;
       public  void CallAPIsyncSearcUsers()
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://192.168.1.102:8080/cooktime1/api/services/getMatchUsers/");
            var user = client.GetAsync(Convert.ToString(search.Text)).Result;
            if (user.IsSuccessStatusCode)
            {
                var responseU = user.Content.ReadAsStringAsync().Result;
                var userserched = JsonConvert.DeserializeObject<List<User>>(responseU);
                x = "si";
            }
        }    
            public  void CallAPIsyncSearcRecipes() 
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://192.168.1.102:8080/cooktime1/api/services/getMatchRecipes/");
            var recipe = client.GetAsync(Convert.ToString(search.Text)).Result;
            if (recipe.IsSuccessStatusCode)
            {
                var responseR = recipe.Content.ReadAsStringAsync().Result;
                var recipeSearched = JsonConvert.DeserializeObject <List<Recet>>(responseR);
                x = "si";
            }
        }
      
        public  void CallAPIsyncSearcEnterprise()
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://192.168.1.102:8080/cooktime1/api/services/getMatchEnterprises/");
            var enterprise = client.GetAsync(search.Text).Result;
            if (enterprise.IsSuccessStatusCode)
            {
                var responseE = enterprise.Content.ReadAsStringAsync().Result;
                var enterpriseSearched = JsonConvert.DeserializeObject<List<Enterprise>>(responseE);
                x = "si";
            }
        }
                 
        private async void searchButton_Clicked(object sender, EventArgs e)
        {

            if (chooseSearch.Text== "User")
            {
                CallAPIsyncSearcUsers();
                
            }else if(chooseSearch.Text == "Recipes")
            {
                search1 = search.Text;
                await Navigation.PushAsync(new RecipeSearchPage());
            }
            else if (chooseSearch.Text == "Enterprise")
            {
                CallAPIsyncSearcEnterprise();
            }
           /*if (x == "si")
            {
                this.DisplayAlert("ATENCION", "MAE ESTAMOS EN LA FAMA", "OK");
            }
            else  { this.DisplayAlert("ATENCION", "MAE ESTAMOS Mamandooooo", "OK"); }*/
        }
        public string getRecipe()
        {
            
            return search1;
        }
    }
}