
//using Android.Telecom;
using CookTime.ViewModels;
using CookTime.ViewModels.News;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Forms
{
    /// <summary>
    /// Page to add business details such as name, email address, and phone number.
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class BusinessRegistrationFormPage : ContentPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="BusinessRegistrationFormPage" /> class.
        /// </summary>
        public BusinessRegistrationFormPage()
        {
            InitializeComponent();
            ListImages();

        }
        private async Task<bool> checkRecipe()
        {
            CallAPIsync();
            if (String.IsNullOrWhiteSpace(RecipeName.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo del nombre es obligatorio.", "OK");
                return false;
            }

            else if (String.IsNullOrWhiteSpace(RecipeAuthor.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo del autor es obligatorio.", "OK");
                return false;
            }

            else if (String.IsNullOrWhiteSpace(DishType.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo del tipo de plato es obligatorio.", "OK");
                return false;
            }


            else if (String.IsNullOrWhiteSpace(FoodType.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo de la comida es obligatorio.", "OK");
                return false;
            }

            else if (!Servings.Text.ToCharArray().All(Char.IsDigit))
            {
                await this.DisplayAlert("Advertencia", "El formato de las porciones de la receta es invalido, solo se aceptan numeros.", "OK");
                return false;
            }
            else if (!Price.Text.ToCharArray().All(Char.IsDigit))
            {
                await this.DisplayAlert("Advertencia", "El formato del precio de la receta es invalido, solo se aceptan numeros.", "OK");
                return false;
            }


            else if (String.IsNullOrWhiteSpace(DifficultyFactor.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo de la dificultad es obligatorio.", "OK");
                return false;
            }

            else if (String.IsNullOrWhiteSpace(PreparationTime.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo de la dificultad es obligatorio.", "OK");
                return false;
            }

            else if (String.IsNullOrWhiteSpace(RecipeIngredients.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo de los ingredientes es obligatorio.", "OK");
                return false;
            }

            else if (String.IsNullOrWhiteSpace(RecipeTags.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo de los tags es obligatorio.", "OK");
                return false;
            }

            else if (String.IsNullOrWhiteSpace(PreparationSteps.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo de los pasos para la preparacion es obligatorio.", "OK");
                return false;
            }
            

            else if( acc==true)
            {
                CallAPIsyncMyMenu();
                if (act == true)
                {
                    return true;
                }
            }return false;
            



            
        }

        private async void SubmitButton_Clicked(object sender, EventArgs e)
        {
           
            if (await checkRecipe())
            {
                await this.DisplayAlert("Comprobacion", "Se ha creado la receta de manera correcta", "OK");
                clearRecipe();
                
            }

        }
        static bool acc;
        static bool act;
        static List<string> recetsImages = new List<string>();
        static int x = 1;
        public  void CallAPIsync()
        {
            HttpClient client = new HttpClient();
            SimpleLoginPage usercito = new SimpleLoginPage();
            User user = usercito.GetUser();
            var recet = new Recet
            {
                author = RecipeAuthor.Text,
                name = RecipeName.Text,
                calification = "2",
                steps = PreparationSteps.Text,
                time = DishType.Text,
                type = FoodType.Text,
                dietTag = RecipeTags.Text,
                price = Price.Text,
                portions = Servings.Text,
                duration = PreparationTime.Text,
                ingredients = RecipeIngredients.Text,
                photo = recetsImages[x],
                publication = "20/07/20",
                difficulty = DifficultyFactor.Text
            };          
            var json = JsonConvert.SerializeObject(recet);
            StringContent content = new StringContent(json, Encoding.UTF8, "application/json");
            var response =   client.PostAsync($"http://192.168.1.102:8080/cooktime1/api/services/postRecipe?name={recet.name}&author={recet.author}&type={recet.type}&portions={recet.portions}&duration={recet.duration}&time={recet.time}&difficulty={recet.difficulty}&dietTag={recet.dietTag}&photo={recet.photo}&ingredients={recet.ingredients}&steps={recet.steps}&price={recet.price}&calification={recet.calification}&publication={recet.publication}", content).Result;
            
            if (response.IsSuccessStatusCode)
            {
              
                acc = true;
                x ++;
            }
            else
            {
                acc = false;
            }
                        
        }
        public void CallAPIsyncMyMenu()
        {
            HttpClient client = new HttpClient();
            SimpleLoginPage usercito = new SimpleLoginPage();
            User user = usercito.GetUser();
            var recet = new Recet
            {        
                name = RecipeName.Text,
                
            };
            var json = JsonConvert.SerializeObject(recet);
            StringContent content = new StringContent(json, Encoding.UTF8, "application/json");
            var response = client.PostAsync($"http://192.168.1.102:8080/cooktime1/api/services/postUserMyMenuList?email={user.email}&newRecipe={recet.name}", content).Result;
            if (response.IsSuccessStatusCode)
            { 
                {
                    act = true;
                }
            }
            else
            {
                act = false;
            }

        }
        public void ListImages()
        {
            recetsImages.Add("Recipe1.png");
            recetsImages.Add("Recipe2.png");
            recetsImages.Add("Recipe3.png");
            recetsImages.Add("Recipe4.png");
            recetsImages.Add("Recipe5.png");
            recetsImages.Add("Recipe6.png");
            recetsImages.Add("Recipe7.png");
            recetsImages.Add("Recipe8.png");
            recetsImages.Add("Recipe9.png");
            recetsImages.Add("Recipe10.png");
            recetsImages.Add("Recipe11.png");
            recetsImages.Add("Recipe12.png");
            recetsImages.Add("Recipe13.png");
            recetsImages.Add("Recipe14.png");
            recetsImages.Add("Recipe15.png");
            recetsImages.Add("Recipe16.png");
            recetsImages.Add("Recipe17.png");
            recetsImages.Add("Recipe18.png");
            recetsImages.Add("Recipe19.png");
            
        }
        public string GetRecipeName()
        {
            string recipeName = RecipeName.Text;
            return recipeName;
        }
        public string GetRecipeAuthor()
        {
            string recipeAuthor = RecipeAuthor.Text;
            return recipeAuthor;
        }
        public string GetDishType()
        {
            string dishType =DishType.Text;
            return dishType;
        }
        public string GetServings()
        {
            string servings =Servings.Text;
            return servings;
        }
        public string GetFoodType()
        {
            string foodType = FoodType.Text;
            return foodType;
        }
        public string GetDifficultyFactor()
        {
            string difficultyFactor =DifficultyFactor.Text;
            return difficultyFactor;
        }
        public string GetPreparationTime()
        {
            string preparationTime = PreparationTime.Text;
            return preparationTime;
        }
        public string GetRecipeIngredients()
        {
            string recipeIngredients = RecipeIngredients.Text;
            return recipeIngredients;
        }
        public string GetRecipeTags()
        {
            string recipeTags = RecipeTags.Text;
            return recipeTags;
        }
        public string GetPreparationSteps()
        {
            string preparationSteps = PreparationSteps.Text;
            return preparationSteps;
        }
        public string GetPrice()
        {
            string price = Price.Text;
            return price;
        }
        public string GetRecipeImage()
        {
            string recipeImage = rte.Text;
            return recipeImage;
        }

        public void clearRecipe()
        {
            RecipeName.Text = string.Empty;
            RecipeAuthor.Text = string.Empty;
            DishType.Text = string.Empty;
            Servings.Text = string.Empty;
            FoodType.Text = string.Empty;
            DifficultyFactor.Text = string.Empty;
            PreparationTime.Text = string.Empty;
            RecipeIngredients.Text = string.Empty;
            RecipeTags.Text = string.Empty;
            PreparationSteps.Text = string.Empty;
            Price.Text = string.Empty;
            rte.Text = string.Empty;
        }

    }
}