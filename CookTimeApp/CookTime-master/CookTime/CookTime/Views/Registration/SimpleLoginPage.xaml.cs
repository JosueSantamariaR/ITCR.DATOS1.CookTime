using System;
using System.Net.Http;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using CookTime.ViewModels;
using CookTime.Views.Navigation;
using Newtonsoft.Json;
using Xamarin.Essentials;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;
namespace CookTime.Views.Forms
{
    /// <summary>
    /// Page to login with user name and password
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class SimpleLoginPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="SimpleLoginPage" /> class.
        /// </summary>
        public SimpleLoginPage()
        {
            InitializeComponent();
        }
        
        static string accept;
        public static string MD5Hash(string input)
        {
            StringBuilder hash = new StringBuilder();
            MD5CryptoServiceProvider md5provider = new MD5CryptoServiceProvider();
            byte[] bytes = md5provider.ComputeHash(new UTF8Encoding().GetBytes(input));

            for (int i = 0; i < bytes.Length; i++)
            {
                hash.Append(bytes[i].ToString("x2"));
            }
            return hash.ToString();
        }
        static User usercito;
        public void CallAPIsync()
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://192.168.1.7:8080/cooktime1/api/services/getUser/");
            var user = client.GetAsync(EmailEntry.Text).Result;
            if (user.IsSuccessStatusCode)
            {
                var response = user.Content.ReadAsStringAsync().Result;
                usercito = JsonConvert.DeserializeObject<User>(response);
                if (usercito.password == MD5Hash(PasswordEntry.Text))
                {
                    accept = "Si";
                }
            }
            else
            {
                accept = "no";
            }
        }
        private void SignUpButton_OnClicked(object sender, EventArgs e)
        {
            ((NavigationPage)this.Parent).PushAsync(new SimpleSignUpPage());
        }
        private async void LoginButtonMain_OnClicked(object sender, EventArgs e)
        {
            if (await CheckLogin())
            {
                await ((NavigationPage)this.Parent).PushAsync(new BottomNavigationPage());
                clearLogin();
            }
        }

        private async Task<bool> CheckLogin()
        {
            if (String.IsNullOrWhiteSpace(EmailEntry.Text) || (String.IsNullOrWhiteSpace(PasswordEntry.Text)))
            {
                await this.DisplayAlert("Advertencia", "Los campos de la contraseña  y correo son obligatorios.", "OK");
                return false;
            }
             CallAPIsync();
            if (accept != "Si")
             {
                 await this.DisplayAlert("Ate", "Contraseña o email incorrectos", "ok");
                 return false;
             }
             return true;
            
            

        }

        private void clearLogin()
        {
            EmailEntry.Text = string.Empty;
            PasswordEntry.Text = string.Empty;
        }

        public User GetUser()
        {
            return usercito;
        }

    }
}

