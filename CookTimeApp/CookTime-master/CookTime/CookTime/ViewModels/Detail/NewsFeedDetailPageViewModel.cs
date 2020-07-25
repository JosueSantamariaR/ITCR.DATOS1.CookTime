using System.Collections.ObjectModel;
using CookTime.ViewModels.News;
using Syncfusion.XForms.Buttons;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Model = CookTime.Models.Article;

namespace CookTime.ViewModels.Detail
{
    /// <summary>
    /// ViewModel for Article Detail page 
    /// </summary> 
    [Preserve(AllMembers = true)]
    public class NewsFeedDetailPageViewModel : BaseViewModel
    {
        #region Fields

        /// <summary>
        /// Gets or sets the article name
        /// </summary>
        

        private string recipeName;
        private string recipeAuthor;
        private string dishType;
        private string servings;
        private string foodType;
        private string diffcultyFactor;
        private string preparationTime;
        private string recipeIngredients;
        private string recipeTags;
        private string preparationSteps;
        private string recipeprice;
        private string recipeImage;
        private string rating;
        private string date;

       
        private ObservableCollection<Model> relatedStories;

        /// <summary>
        /// Gets or sets the article content list.
        /// </summary>
        private ObservableCollection<Model> contentList;



        #endregion

        #region Constructor

        /// <summary>
        /// Initializes a new instance of the <see cref="DetailViewModel" /> class
        /// </summary>
        public NewsFeedDetailPageViewModel(Recet recet)
        {
            this.recipeName = recet.name;
            this.recipeAuthor = recet.author;
            this.dishType = recet.type;
            this.servings = recet.portions;
            this.foodType = recet.duration;
            this.diffcultyFactor = recet.difficulty;
            this.preparationTime = recet.time;
            this.recipeIngredients = recet.ingredients;
            this.recipeTags = recet.dietTag;
            this.preparationSteps = recet.steps;
            this.price = recet.price;
            this.recipeImage = recet.Photo;
            this.rating = recet.calification;
            this.date = recet.publication;

            this.FavouriteCommand = new Command(this.FavouriteButtonClicked);
            this.BookmarkCommand = new Command(this.BookmarkButtonClicked);
            this.ItemSelectedCommand = new Command(this.ItemClicked);
        }

        #endregion

        #region Public properties

        /// <summary>
        /// Gets or sets the article name
        /// </summary>
        /// 


         public string name
        {
            get
            {
                return this.recipeName;
            }

            set
            {
                if (this.recipeName != value)
                {
                    this.recipeName = value;
                    this.NotifyPropertyChanged();
                }
            }
        }

        public string author
        {
            get
            {
                return this.recipeAuthor;
            }

            set
            {
                if (this.recipeAuthor != value)
                {
                    this.recipeAuthor = value;
                    this.NotifyPropertyChanged();
                }
            }
        }

        public string type
        {
            get
            {
                return this.dishType;
            }

            set
            {
                if (this.dishType != value)
                {
                    this.dishType = value;
                    this.NotifyPropertyChanged();
                }
            }
        }


        public string portions
        {
            get
            {
                return this.servings;
            }

            set
            {
                if (this.servings != value)
                {
                    this.servings = value;
                    this.NotifyPropertyChanged();
                }
            }
        }


        public string duration
        {
            get
            {
                return this.foodType;
            }

            set
            {
                if (this.foodType != value)
                {
                    this.foodType = value;
                    this.NotifyPropertyChanged();
                }
            }
        }


        public string difficulty
        {
            get
            {
                return this.diffcultyFactor;
            }

            set
            {
                if (this.diffcultyFactor != value)
                {
                    this.diffcultyFactor = value;
                    this.NotifyPropertyChanged();
                }
            }
        }

        public string time
        {
            get
            {
                return this.preparationTime;
            }

            set
            {
                if (this.preparationTime != value)
                {
                    this.preparationTime = value;
                    this.NotifyPropertyChanged();
                }
            }
        }


        public string ingredients
        {
            get
            {
                return this.recipeIngredients;
            }

            set
            {
                if (this.recipeIngredients == value)
                {
                    return;
                }

                this.recipeIngredients = value;
                this.NotifyPropertyChanged();
            }
        }

        public string dietTag
        {
            get
            {
                return this.recipeTags;
            }

            set
            {
                if (this.recipeTags == value)
                {
                    return;
                }

                this.recipeTags = value;
                this.NotifyPropertyChanged();
            }
        }

        public string steps
        {
            get
            {
                return this.preparationSteps;
            }

            set
            {
                if (this.preparationSteps != value)
                {
                    this.preparationSteps = value;
                    this.NotifyPropertyChanged();
                }
            }
        }

        public string calification
        {
            get
            {
                return this.rating;
            }

            set
            {
                if (this.rating != value)
                {
                    this.rating = value;
                    this.NotifyPropertyChanged();
                }
            }
        }

        public string price
        {
            get
            {
                return this.recipeprice;
            }

            set
            {
                if (this.recipeprice != value)
                {
                    this.recipeprice = value;
                    this.NotifyPropertyChanged();
                }
            }
        }
        public string publication
        {
            get
            {
                return this.date;
            }

            set
            {
                if (this.date != value)
                {
                    this.date = value;
                    this.NotifyPropertyChanged();
                }
            }
        }




        public string Photo
        {
            get
            {
                return this.recipeImage;
            }

            set
            {
                if (this.recipeImage != value)
                {
                    this.recipeImage = value;
                    this.NotifyPropertyChanged();
                }
            }
        }
 
        /// <summary>
        /// Gets or sets the property has been bound with the list view which displays the articles related stories items.
        /// </summary>
        public ObservableCollection<Model> RelatedStories
        {
            get
            {
                return this.relatedStories;
            }

            set
            {
                if (this.relatedStories == value)
                {
                    return;
                }

                this.relatedStories = value;
                this.NotifyPropertyChanged();
            }
        }

        /// <summary>
        /// Gets or sets the property has been bound with the list view which displays the articles content list items.
        /// </summary>
        public ObservableCollection<Model> ContentList
        {
            get
            {
                return this.contentList;
            }

            set
            {
                if (this.contentList == value)
                {
                    return;
                }

                this.contentList = value;
                this.NotifyPropertyChanged();
            }
        }

        

        #endregion

        #region Command
        /// <summary>
        /// Gets or sets the command is executed when the favourite button is clicked.
        /// </summary>
        public Command FavouriteCommand { get; set; }

        /// <summary>
        /// Gets or sets the command is executed when the book mark button is clicked.
        /// </summary>
        public Command BookmarkCommand { get; set; }

        /// <summary>
        /// Gets or sets the command is executed when the related features item is clicked.
        /// </summary>
        public Command ItemSelectedCommand { get; set; }

        #endregion

        #region Methods

        /// <summary>
        /// Invoked when the favourite button clicked
        /// </summary>
        /// <param name="obj">The object</param>
        private void FavouriteButtonClicked(object obj)
        {
            var button = obj as SfButton;

            if (button == null)
            {
                return;
            }

            if (button.Text == "\ue701")
            {
                button.Text = "\ue732";
                Application.Current.Resources.TryGetValue("PrimaryColor", out var retVal);
                button.TextColor = (Color)retVal;
            }
            else
            {
                button.Text = "\ue701";
                Application.Current.Resources.TryGetValue("Gray-600", out var retVal);
                button.TextColor = (Color)retVal;
            }
        }

        /// <summary>
        /// Invoked when the related features item clicked
        /// </summary>
        /// <param name="obj">The object</param>
        private void ItemClicked(object obj)
        {
            // Do something
        }

        /// <summary>
        /// Invoked when the bookmark button clicked
        /// </summary>
        /// <param name="obj">The object</param>
        private void BookmarkButtonClicked(object obj)
        {
            if (obj != null && (obj is Model))
            {
                (obj as Model).IsBookmarked = (obj as Model).IsBookmarked ? false : true;
            }
            else
            {
                var button = obj as SfButton;
                if (button != null)
                {
                    button.Text = (button.Text == "\ue72f") ? "\ue734" : "\ue72f";
                }
            }
        }

        #endregion
    }
}
