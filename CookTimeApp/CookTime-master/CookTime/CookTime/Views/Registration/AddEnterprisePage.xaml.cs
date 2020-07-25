//using Android.Telecom;
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
    /// This page used for adding Profile image with Name and phone number.
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class AddProfilePage : ContentPage
    {
        public AddProfilePage()
        {
            InitializeComponent();
        }

        private async void AddEnterprise_Clicked(object sender, System.EventArgs e)
        {
            await checkEnterprise();
        }
        private async Task<bool> checkEnterprise()

        {
          CallAPIsync();
            if (String.IsNullOrWhiteSpace(EnterpriseName.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo del nombre es obligatorio.", "OK");
                return false;
            }

            else if (String.IsNullOrWhiteSpace(Schedule.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo de horario de servicio es obligatorio.", "OK");
                return false;
            }
            else if (String.IsNullOrWhiteSpace(ContactMethod.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo del contacto es obligatorio.", "OK");
                return false;
            }
            else if (String.IsNullOrWhiteSpace(Address.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo de la direción es obligatorio.", "OK");
                return false;
            }
             else if (acc == true)
             {
                await this.DisplayAlert("Comprobación", "Empresa creada con éxito", "OK");
                 return true;
                
             }
             return false;
            

        }
        static bool acc;
        public void CallAPIsync()
        {
            HttpClient client = new HttpClient();
            var enterprise = new Enterprise
            {
                name= EnterpriseName.Text,
                schedule= Schedule.Text,
                contact= ContactMethod.Text,
                direction=Address.Text,
                logo="LOGO MAMALON",
                members= Members.Text
            };

            var json = JsonConvert.SerializeObject(enterprise);
            StringContent content = new StringContent(json, Encoding.UTF8, "application/json");
            var response = client.PostAsync($"http://192.168.1.102:8080/cooktime1/api/services/postEnterprise/?name={enterprise.name}&logo={enterprise.logo}.png&contact={enterprise.contact}&schedule={enterprise.schedule}&direction={enterprise.direction}&members={enterprise.members}", content).Result;
            if (response.IsSuccessStatusCode)
            {
                acc = true; 
            }
            else
            {
                acc = false;
            }
        }

        public void clearEnterprise()
        {
            EnterpriseName.Text = string.Empty;
            Address.Text = string.Empty;
            Schedule.Text = string.Empty;
            ContactMethod.Text = string.Empty;
        }
    }
}