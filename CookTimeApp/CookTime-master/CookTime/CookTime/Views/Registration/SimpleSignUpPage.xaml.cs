using CookTime.ViewModels;
using Newtonsoft.Json;
using System;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Forms
{
    /// <summary>
    /// Page to sign in with user details.
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class SimpleSignUpPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="SimpleSignUpPage" /> class.
        /// </summary>
        public SimpleSignUpPage()
        {
            InitializeComponent();

        }

        private async void LoginButton_OnClicked(object sender, EventArgs e)
        {
            await Navigation.PopToRootAsync();
        }

        private async void RegisterButton_OnClicked(object sender, EventArgs e)
        {
            if (await checkSignUp())
            {
                await Navigation.PopToRootAsync();
                clearSignUp();
            }
        }

        private async Task<bool> checkSignUp()
        {
            //CallAPIsync();
            if (String.IsNullOrWhiteSpace(NameEntrySignUp.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo del nombre es obligatorio.", "OK");
                return false;
            }

            else if (String.IsNullOrWhiteSpace(EmailEntrySignUp.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo del correo es obligatorio.", "OK");
                return false;
            }
            else if (String.IsNullOrWhiteSpace(PasswordEntrySignUp.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo de la contraseña es obligatorio.", "OK");
                return false;
            }
            else if (String.IsNullOrWhiteSpace(ConfirmPasswordEntrySignUp.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo de la confirmacion es obligatorio.", "OK");
                return false;
            }
            else if (String.IsNullOrWhiteSpace(YearsSignUp.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo de los años es obligatorio.", "OK");
                return false;
            }
            else if (ConfirmPasswordEntrySignUp.Text != PasswordEntrySignUp.Text)
            {
                await this.DisplayAlert("Advertencia", "Las contraseñas deben de ser iguales.", "OK");
                return false;
            }
            /* else if (acc == true)
             {
                 await this.DisplayAlert("Exitoso", "Usuario creado satisfactoriamente", "OK");
                 return true;
             }
             await this.DisplayAlert("Advetencia", "Email ya registrado, favor intente con otro", "OK");
             return false;*/
            return true;
        }


            /*bool acc;
        public void CallAPIsync()
        {
            HttpClient clientC = new HttpClient();
            HttpClient client = new HttpClient();
            var user = new User
            {
                age = Convert.ToInt32(YearsSignUp.Text),
                email = EmailEntrySignUp.Text,
                name = NameEntrySignUp.Text,
                password = PasswordEntrySignUp.Text,
                lastName ="gonza",
                chef = false,
                photo="photo"
            };
            var json = JsonConvert.SerializeObject(user );
            StringContent content = new StringContent(json, Encoding.UTF8, "application/json");
            clientC.BaseAddress = new Uri("http://192.168.1.102:8080/cooktime1/api/services/getUser/");
            var check = clientC.GetAsync(user.email).Result;
            if (check.IsSuccessStatusCode)
            {
                acc = false;
            }
            else
            {
                var response = client.PostAsync($"http://192.168.1.102:8080/cooktime1/api/services/postUser?email={user.email}&name={user.name}&lastName={user.lastName}&age={user.age}&password={user.password}&photo={user.photo}&chef={user.chef}", content).Result;
                if (response.IsSuccessStatusCode)
                {
                    acc = true; ;
                }
                else
                {
                    acc = false;
                }
            }
        }*/
        public string GetName()
        {
            string name = NameEntrySignUp.Text;
            return name;
        }
        public string GetEmail()
        {
            string email = EmailEntrySignUp.Text;
            return email;
        }
        public string GetYears()
        {
            string years = YearsSignUp.Text;
            return years;
        }
        public string GetPassword()
        {
            string password = PasswordEntrySignUp.Text;
            return password;
        }

        public void clearSignUp()
        {
            NameEntrySignUp.Text = string.Empty;
            LastNameEntrySignUp.Text = string.Empty;
            YearsSignUp.Text = string.Empty;
            PasswordEntrySignUp.Text = string.Empty;
            ConfirmPasswordEntrySignUp.Text = string.Empty;
        }






    }
}