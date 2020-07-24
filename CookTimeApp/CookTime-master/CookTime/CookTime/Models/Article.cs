using CookTime.ViewModels;
using Xamarin.Forms.Internals;

namespace CookTime.Models
{
    /// <summary>
    /// Model for Article templates.
    /// </summary>
    [Preserve(AllMembers = true)]
    public class Article : BaseViewModel
    {
        #region Fields

        /// <summary>
        /// Gets or sets a value indicating whether the article is bookmarked
        /// </summary>
        private bool isBookmarked;

        /// <summary>
        /// Gets or sets a value indicating whether the article is favourite.
        /// </summary>
        private bool isFavourite;
        
        #endregion


        #region Public Properties

        public string RecipeName { get; set; }
        public string RecipeAuthor { get; set; }
        public string DishType { get; set; }
        public string Servings { get; set; }
        public string FoodType { get; set; }
        public string DifficultyFactor { get; set; }
        public string PreparationTime { get; set; }
        public string RecipeIngredients { get; set; }
        public string RecipeTags { get; set; }
        public string PreparationSteps { get; set; }
        public string Price { get; set; }

        public string Rating { get; set; }
        public string Date { get; set; }
        public string RecipeImage { get; set; }











        /// <summary>
        /// Gets or sets the article image path.
        /// </summary>
        public string ImagePath { get; set; }

        /// <summary>
        /// Gets or sets the article name.
        /// </summary>
        public string Name { get; set; }

        /// <summary>
        /// Gets or sets the article author name.
        /// </summary>
        public string Author { get; set; }


        /// <summary>
        /// Gets or sets the article publish date.
        /// </summary>
        

        /// <summary>
        /// Gets or sets the article read time.
        /// </summary>
        public string AverageReadingTime { get; set; }

        /// <summary>
        /// Gets or sets the article description
        /// </summary>
        public string Description { get; set; }

        /// <summary>
        /// Gets or sets a value indicating whether the article is bookmarked.
        /// </summary>
        public bool IsBookmarked
        {
            get
            {
                return this.isBookmarked;
            }

            set
            {
                this.isBookmarked = value;
                this.NotifyPropertyChanged();
            }
        }

        /// <summary>
        /// Gets or sets a value indicating whether the article is favourite.
        /// </summary>
        public bool IsFavourite
        {
            get
            {
                return this.isFavourite;
            }

            set
            {
                this.isFavourite = value;
                this.NotifyPropertyChanged();
            }
        }

        /// <summary>
        /// Gets or sets the bookmarked count.
        /// </summary>
        public int BookmarkedCount { get; set; }

        /// <summary>
        /// Gets or sets the favourite count.
        /// </summary>
        public int FavouritesCount { get; set; }

        /// <summary>
        /// Gets or sets the shared count.
        /// </summary>
        public int SharedCount { get; set; }

        #endregion
    }
}