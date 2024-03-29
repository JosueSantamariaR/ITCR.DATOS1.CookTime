﻿using CookTime.ViewModels;
using CookTime.ViewModels.News;
using CookTime.ViewModels.Social;
using CookTime.Views.Catalog;
using CookTime.Views.Forms;
using Java.Lang;
using Newtonsoft.Json;
using System;
using System.Net.Http;
using System.Text;
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
        /// 
        static string userfollowed;
        static bool accept;
        static bool accept2;
        static int followers;
        static int following;
        public SearchProfileDetailPage(User user)
        {
            CallAPIsyncFollowed();
            CallAPIsyncFollowing();
            
            InitializeComponent();
<<<<<<< HEAD:CookTimeApp/CookTime-master/CookTime/CookTime/Views/Profile/SearchProfileDetailPage.xaml.cs
            BindingContext = new SearchUserTappedDetailViewModel(user);
            userfollowed = user.email;
        }

       

        private void follow_Clicked(object sender, System.EventArgs e)
        {
            CallAPIsync();
            if (accept == true)
            {
                CallAPIsyncNotification(); 
                if (accept2 == true)
                {
                    this.DisplayAlert("Comprobación", "Se ha seguido el usuario", "ok");
                }
            }
            else { this.DisplayAlert("Comprobación", "No se ha seguido el usuario", "ok"); }
        }
        public void CallAPIsync()
        {
            HttpClient client = new HttpClient();
            SimpleLoginPage usercito = new SimpleLoginPage();
            User userC = usercito.GetUser();
            var json = JsonConvert.SerializeObject(userC);
            StringContent content = new StringContent(json, Encoding.UTF8, "application/json");
            var response = client.PostAsync($"http://192.168.1.102:8080/cooktime1/api/services/postUserFollowed?email={userC.email}&followedEmail={userfollowed}", content).Result;
            if (response.IsSuccessStatusCode) {
                accept = true;
            }
            
        }
        public void CallAPIsyncNotification()
        {
            HttpClient client = new HttpClient();
            SimpleLoginPage usercito = new SimpleLoginPage();
            User userC = usercito.GetUser();
            var json = JsonConvert.SerializeObject(userC);
            StringContent content = new StringContent(json, Encoding.UTF8, "application/json");
            var response = client.PostAsync($"http://192.168.1.102:8080/cooktime1/api/services/postUserFollowers/{userfollowed}", content).Result;
            if (response.IsSuccessStatusCode)
            {
                accept2 = true;
            }

        }
        public void CallAPIsyncFollowed()
        {
            HttpClient client = new HttpClient();
                   
            var response = client.GetAsync($"http://192.168.1.102:8080/cooktime1/api/services/getUserFollowed/{userfollowed}").Result;
            if (response.IsSuccessStatusCode) {
                var temp = response.Content.ReadAsStringAsync().Result;
                var temp2= JsonConvert.DeserializeObject<Integer>(temp);
                following = Convert.ToInt32(temp2);
            }
            

=======
            BindingContext = new SocialProfileViewModel2(user);
>>>>>>> parent of 2f9160a... Update:CookTimeApp/CookTime-master/CookTime/CookTime/Views/Profile/Templates/SearchProfileDetailPage.xaml.cs
        }
        public void CallAPIsyncFollowing()
        {
            HttpClient client = new HttpClient();
            SimpleLoginPage usercito = new SimpleLoginPage();
            User userC = usercito.GetUser();
            var json = JsonConvert.SerializeObject(userC);
            StringContent content = new StringContent(json, Encoding.UTF8, "application/json");
            var response = client.GetAsync($"http://192.168.1.102:8080/cooktime1/api/services/getUserFollowers/{userfollowed}").Result;
            if (response.IsSuccessStatusCode) {
                var temp = response.Content.ReadAsStringAsync().Result;
                var temp2 = JsonConvert.DeserializeObject<Integer>(temp);
                followers = Convert.ToInt32(temp2);
            }
            

        }

        private async void myMenu_Clicked_1(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new UserSearchMyMenuPage());
        }
        public string getUserSearch()
        {
            return userfollowed;
        }
        
    }
}