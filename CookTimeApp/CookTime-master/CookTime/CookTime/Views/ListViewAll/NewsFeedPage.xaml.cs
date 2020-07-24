using CookTime.ViewModels;
using CookTime.ViewModels.Catalog;
using CookTime.ViewModels.News;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Catalog
{
    /// <summary>
    /// Page to list out article items.
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class NewsFeedPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="ArticleListPage" /> class.
        /// </summary>
        public NewsFeedPage()
        {
           
            InitializeComponent();
            BindingContext = new NewsFeedViewModel(Navigation);
        }
    }
}