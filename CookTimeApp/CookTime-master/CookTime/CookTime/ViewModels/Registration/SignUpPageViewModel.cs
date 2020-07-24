using Xamarin.Forms;
using Xamarin.Forms.Internals;

namespace CookTime.ViewModels.Forms
{
    /// <summary>
    /// ViewModel for sign-up page.
    /// </summary>
    [Preserve(AllMembers = true)]
    public class SignUpPageViewModel : LoginViewModel
    {
        #region Fields

        private string nameSignUp;

        private string emailSignUp;

        private string yearsSignUp;

        private string passwordSignUp;

        private string confirmPasswordSignUp;


        #endregion

        #region Constructor

        /// <summary>
        /// Initializes a new instance for the <see cref="SignUpPageViewModel" /> class.
        /// </summary>
        public SignUpPageViewModel()
        {
            this.LoginCommand = new Command(this.LoginClicked);
            this.SignUpCommand = new Command(this.SignUpClicked);
        }

        #endregion

        #region Property

        public string NameSignUp
        {
            get
            {
                return this.nameSignUp;
            }

            set
            {
                if (this.nameSignUp == value)
                {
                    return;
                }

                this.nameSignUp = value;
                this.NotifyPropertyChanged();
            }
        }


        public string EmailSignUp
        {
            get
            {
                return this.emailSignUp;
            }

            set
            {
                if (this.emailSignUp == value)
                {
                    return;
                }

                this.emailSignUp = value;
                this.NotifyPropertyChanged();
            }
        }


        public string YearsSignUp
        {
            get
            {
                return this.yearsSignUp;
            }

            set
            {
                if (this.yearsSignUp == value)
                {
                    return;
                }

                this.yearsSignUp = value;
                this.NotifyPropertyChanged();
            }
        }


        public string PasswordSignUp
        {
            get
            {
                return this.passwordSignUp;
            }

            set
            {
                if (this.passwordSignUp == value)
                {
                    return;
                }

                this.passwordSignUp = value;
                this.NotifyPropertyChanged();
            }
        }


        public string ConfirmPasswordSignUp
        {
            get
            {
                return this.confirmPasswordSignUp;
            }

            set
            {
                if (this.confirmPasswordSignUp == value)
                {
                    return;
                }

                this.confirmPasswordSignUp = value;
                this.NotifyPropertyChanged();
            }
        }


        

        #endregion

        #region Command

        /// <summary>
        /// Gets or sets the command that is executed when the Log In button is clicked.
        /// </summary>
        public Command LoginCommand { get; set; }

        /// <summary>
        /// Gets or sets the command that is executed when the Sign Up button is clicked.
        /// </summary>
        public Command SignUpCommand { get; set; }

        #endregion

        #region Methods

        /// <summary>
        /// Invoked when the Log in button is clicked.
        /// </summary>
        /// <param name="obj">The Object</param>
        private void LoginClicked(object obj)
        {
            // Do something
        }

        /// <summary>
        /// Invoked when the Sign Up button is clicked.
        /// </summary>
        /// <param name="obj">The Object</param>
        private void SignUpClicked(object obj)
        {
            // Do something
        }

        #endregion
    }
}