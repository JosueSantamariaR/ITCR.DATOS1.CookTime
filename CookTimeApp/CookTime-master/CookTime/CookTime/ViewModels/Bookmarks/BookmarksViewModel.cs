using CookTime.Controls;
using System.Collections.ObjectModel;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Model = CookTime.Models.Article;

namespace CookTime.ViewModels.Bookmarks
{
    /// <summary>
    /// ViewModel for Article bookmark page 
    /// </summary> 
    [Preserve(AllMembers = true)]
    public class BookmarksViewModel : BaseViewModel
    {
        #region Fields

        private ObservableCollection<Model> latestStories;

        #endregion

        #region Constructor

        /// <summary>
        /// Initializes a new instance for the <see cref="BookmarksViewModel" /> class.
        /// </summary>
        public BookmarksViewModel()
        {
            this.LatestStories = new ObservableCollection<Model>
            {
                new Model
                {
                    ImagePath = App.BaseImageUrl + "Recipe1.png",
                    Name = "Hamburger",
                    Author = "Burger King",
                    IsBookmarked = true,
                    
                }
            };

            this.BookmarkCommand = new Command(this.BookmarkButtonClicked);
            this.ItemSelectedCommand = new Command(this.ItemSelected);
        }

        #endregion

        #region Public Properties        

        /// <summary>
        /// Gets or sets the property that has been bound with the list view, which displays the articles' latest stories items.
        /// </summary>
        public ObservableCollection<Model> LatestStories
        {
            get { return this.latestStories; }

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
        /// Gets or sets the command that will be executed when the bookmark button is clicked.
        /// </summary>
        public Command BookmarkCommand { get; set; }

        /// <summary>
        /// Gets or sets the command that will be executed when an item is selected.
        /// </summary>
        public Command ItemSelectedCommand { get; set; }

        #endregion

        #region Methods

        /// <summary>
        /// Invoked when the bookmark button is clicked.
        /// </summary>
        /// <param name="obj">The object</param>
        private void BookmarkButtonClicked(object obj)
        {
            if (obj is Model article)
            {
                this.LatestStories.Remove(article);

                if (this.LatestStories.Count == 0)
                {
                    SfPopupView sfPopupView = new SfPopupView();
                    sfPopupView.ShowPopUp(content: "No bookmarks here");
                }
            }
        }

        /// <summary>
        /// Invoked when an item is selected.
        /// </summary>
        private void ItemSelected(object obj)
        {
            // Do something
        }

        #endregion
    }
}