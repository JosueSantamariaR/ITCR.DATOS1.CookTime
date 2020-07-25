﻿using CookTime.Views.Forms;
using CookTime.Views.Social;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Net.Http;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Model = CookTime.ViewModels.User;

namespace CookTime.ViewModels.Catalog
{
    /// <summary>
    /// ViewModel for article list page.
    /// </summary> 
    [Preserve(AllMembers = true)]
    public class UserSearchViewModel : BaseViewModel
    {
        #region Fields

        INavigation Navigation { get; set; }

        private ObservableCollection<Model> latestStories;

        #endregion

        #region Constructor
        /// <summary>
        /// Initializes a new instance for the <see cref="UserSearchViewModel" /> class.
        /// </summary>
        public UserSearchViewModel(INavigation _navigation)
        {

            Navigation = _navigation;
            CallAPIsync();

            this.MenuCommand = new Command(this.MenuClicked);

            this.FeatureStoriesCommand = new Command(this.FeatureStoriesClicked);
            this.ItemSelectedCommand = new Command(this.ItemSelected);
        }
        #endregion

        #region Public Properties
        /// <summary>
        /// Gets or sets the property that has been bound with the rotator view, which displays the articles featured stories items.
        /// </summary>
       

        /// <summary>
        /// Gets or sets the property that has been bound with the list view, which displays the articles latest stories items.
        /// </summary>
        public ObservableCollection<Model> LatestStories
        {
            get
            {
                return this.latestStories;
            }

            set
            {
                if (this.latestStories == value)
                {
                    return;
                }

                this.latestStories = value;
                this.NotifyPropertyChanged();
            }
        }
        #endregion

        #region Command

        /// <summary>
        /// Gets or sets the command that will be executed when the menu button is clicked.
        /// </summary>
        public Command MenuCommand { get; set; }

        /// <summary>
        /// Gets or sets the command that will be executed when the bookmark button is clicked.
        /// </summary>
        public Command BookmarkCommand { get; set; }

        /// <summary>
        /// Gets or sets the command that will executed when the feature stories item is clicked.
        /// </summary>
        public Command FeatureStoriesCommand { get; set; }

        /// <summary>
        /// Gets or sets the command that will be executed when an item is selected.
        /// </summary>
        public Command ItemSelectedCommand { get; set; }

        #endregion

        #region Methods

        /// <summary>
        /// Invoked when the menu button is clicked.
        /// </summary>
        /// <param name="obj">The Object</param>
        private void MenuClicked(object obj)
        {
            // Do something
        }

        /// <summary>
        /// Invoked when the bookmark button is clicked.
        /// </summary>
        /// <param name="obj">The object</param>


        /// <summary>
        /// Invoked when the the feature stories item is clicked.
        /// </summary>
        /// <param name="obj">The object</param>
        private void FeatureStoriesClicked(object obj)
        {
            // Do something
        }

        /// <summary>
        /// Invoked when an item is selected.
        /// </summary>
        /// <param name="obj">The Object</param>
        private void ItemSelected(object obj)
        {
            var item = obj as Syncfusion.ListView.XForms.ItemTappedEventArgs;
            Navigation.PushAsync(new SearchProfileDetailPage(item.ItemData as User));
        }
        public void CallAPIsync()
        {
            MainSearchPage listr = new MainSearchPage();
            var x = listr.getRecipe();
            HttpClient client = new HttpClient();
            var endopoint = client.BaseAddress = new Uri($"http://192.168.1.7:8080/cooktime1/api/services/getUserMatch/{x}");
            var recets = client.GetAsync(endopoint).Result;
            if (recets.IsSuccessStatusCode)
            {
                var response = recets.Content.ReadAsStringAsync().Result;
                var userResponse = JsonConvert.DeserializeObject<List<User>>(response);
                LatestStories = new ObservableCollection<User>(userResponse);

            }
        }

        #endregion
    }
}
