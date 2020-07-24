using System;
using System.Threading.Tasks;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Forms
{
    /// <summary>
    /// Page to reset old password
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class SimpleResetPasswordPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="SimpleResetPasswordPage" /> class.
        /// </summary>
        public SimpleResetPasswordPage()
        {
            InitializeComponent();
        }

        private async void SubmitButton_Clicked(object sender, EventArgs e)
        {
            if (await checkNewPassword() && await SamePasswords())
            {
                await Navigation.PopToRootAsync();
            }
        }

        private async Task<bool> checkNewPassword()
        {

            if (String.IsNullOrWhiteSpace(NewPasswordEntry.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo del contraseña es obligatorio.", "OK");
                return false;
            }

            else if (String.IsNullOrWhiteSpace(ConfirmNewPasswordEntry.Text))
            {
                await this.DisplayAlert("Advertencia", "El campo de la confirmacion es obligatorio.", "OK");
                return false;
            }

            else if (String.IsNullOrWhiteSpace(OldPasswordEntry.Text))
            {
                await this.DisplayAlert("Advertencia", "Escibir la contraseña actual es obligatorio.", "OK");
                return false;
            }



            return true;
        }

        private async Task<bool> SamePasswords()
        {

            if ((NewPasswordEntry.Text)==(ConfirmNewPasswordEntry.Text))
            {
                return true;
            }

            else
            {
                await this.DisplayAlert("Advertencia", "Escibir las contraseñas deben de coincidir.", "OK");
                return false;
            }
        }


    }
}