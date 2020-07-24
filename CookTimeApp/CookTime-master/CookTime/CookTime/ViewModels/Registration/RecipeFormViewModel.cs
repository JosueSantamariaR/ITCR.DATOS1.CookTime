using System;
using Xamarin.Forms;
using Xamarin.Forms.Internals;

namespace CookTime.ViewModels.Forms
{
    /// <summary>
    /// ViewModel for Business Registration Form page 
    /// </summary> 
    [Preserve(AllMembers = true)]
    public class RecipeFormViewModel : BaseViewModel
    {
        #region fields

        private string recipeName;
        private string recipeAuthor;
        private string dishType;
        private string servings;
        private string foodType;
        private string difficultyFactor;
        private string preparationTime;
        private string recipeIngredients;
        private string recipeTags;
        private string preparationSteps;
        private string price;
        private string recipeImage;
        #endregion


        #region Constructor

        /// <summary>
        /// Initializes a new instance of the <see cref="RecipeFormViewModel" /> class
        /// </summary>
        public RecipeFormViewModel()
        {
            this.SubmitCommand = new Command(this.SubmitClicked);
        }
        #endregion

        #region Properties

        public string RecipeName
        {
            get
            {
                return this.recipeName;
            }

            set
            {
                if (this.recipeName == value)
                {
                    return;
                }

                this.recipeName = value;
                this.NotifyPropertyChanged();
            }
        }

        public string RecipeAuthor
        {
            get
            {
                return this.recipeAuthor;
            }

            set
            {
                if (this.recipeAuthor == value)
                {
                    return;
                }

                this.recipeAuthor = value;
                this.NotifyPropertyChanged();
            }
        }
        public string DishType
        {
            get
            {
                return this.dishType;
            }

            set
            {
                if (this.dishType == value)
                {
                    return;
                }

                this.dishType = value;
                this.NotifyPropertyChanged();
            }
        }
        public string Servings
        {
            get
            {
                return this.servings;
            }

            set
            {
                if (this.servings == value)
                {
                    return;
                }

                this.servings = value;
                this.NotifyPropertyChanged();
            }
        }
        public string FoodType
        {
            get
            {
                return this.foodType;
            }

            set
            {
                if (this.foodType == value)
                {
                    return;
                }

                this.foodType = value;
                this.NotifyPropertyChanged();
            }
        }
        public string DifficultyFactor
        {
            get
            {
                return this.difficultyFactor;
            }

            set
            {
                if (this.difficultyFactor == value)
                {
                    return;
                }

                this.difficultyFactor = value;
                this.NotifyPropertyChanged();
            }
        }
        public string PreparationTime
        {
            get
            {
                return this.preparationTime;
            }

            set
            {
                if (this.preparationTime == value)
                {
                    return;
                }

                this.preparationTime = value;
                this.NotifyPropertyChanged();
            }
        }
        public string RecipeIngredients
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
        public string RecipeTags
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
        public string PreparationSteps
        {
            get
            {
                return this.preparationSteps;
            }

            set
            {
                if (this.preparationSteps == value)
                {
                    return;
                }

                this.preparationSteps = value;
                this.NotifyPropertyChanged();
            }
        }
        public string Price
        {
            get
            {
                return this.price;
            }

            set
            {
                if (this.price == value)
                {
                    return;
                }

                this.price = value;
                this.NotifyPropertyChanged();
            }
        }
        public string RecipeImage
        {
            get
            {
                return this.recipeImage;
            }

            set
            {
                if (this.recipeImage == value)
                {
                    return;
                }

                this.recipeImage = value;
                this.NotifyPropertyChanged();
            }
        }




        #endregion 

        #region Comments

        /// <summary>
        /// Gets or sets the command is executed when the Submit button is clicked.
        /// </summary>
        public Command SubmitCommand { get; set; }

        #endregion

        #region Methods

        /// <summary>
        /// Invoked when the Submit button clicked
        /// </summary>
        /// <param name="obj">The object</param>
        private void SubmitClicked(Object obj)
        {

        }




        #endregion
    }
}