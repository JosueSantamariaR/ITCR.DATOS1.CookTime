using Syncfusion.XForms.Buttons;
using System.Collections.ObjectModel;
using System.Windows.Input;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using ProfileModel = CookTime.ViewModels.User;

namespace CookTime.ViewModels.Social
{
    /// <summary>
    /// ViewModel for social profile pages.
    /// </summary>
    [Preserve(AllMembers = true)]
    public class SearchUserTappedDetailViewModel  : BaseViewModel
    {
        #region Fields

        private ObservableCollection<ProfileModel> interests;

        private ObservableCollection<ProfileModel> connnections;

        private ObservableCollection<ProfileModel> pictures;

        private string headerImagePath;

        private string profileImage;

        private string backgroundImage;



        private string ageUser;
        private string chefUser;
        private string emailUser;
        private string lastNameUser;
        private string nameUser;
        private string passwordUser;
        private string photoUser;


        #endregion

        #region Constructor

        /// <summary>
        /// Initializes a new instance for the <see cref="SocialProfileViewModel" /> class.
        /// </summary>
        public SearchUserTappedDetailViewModel (User user)
        {
            this.HeaderImagePath = "Album2.png";
            this.BackgroundImage = "Sky-Image.png";
            
            
            this.PostsCount = 8;
            this.FollowersCount = 45;
            this.FollowingCount = 45;

            this.ageUser = user.Age;
            this.chefUser = user.Chef;
            this.emailUser = user.email;
            this.lastNameUser = user.lastName;
            this.nameUser = user.name;
            this.passwordUser = user.password;
            this.photoUser = user.Photo;


           


            this.FollowCommand = new Command(this.FollowClicked);
            this.MessageCommand = new Command(this.MessageClicked);
            this.AddConnectionCommand = new Command(this.AddConnectionClicked);
            this.ImageTapCommand = new Command(this.ImageClicked);
            this.ProfileSelectedCommand = new Command(this.ProfileClicked);
        }

        #endregion

        #region Commands

        /// <summary>
        /// Gets or sets the command that is executed when the Follow button is clicked.
        /// </summary>
        public ICommand FollowCommand { get; set; }

        /// <summary>
        /// Gets or sets the command that is executed when the message button is clicked.
        /// </summary>
        public ICommand MessageCommand { get; set; }

        /// <summary>
        /// Gets or sets the command that is executed when the AddConnection button is clicked.
        /// </summary>
        public ICommand AddConnectionCommand { get; set; }

        /// <summary>
        /// Gets or sets the command that is executed when the Image is tapped.
        /// </summary>
        public ICommand ImageTapCommand { get; set; }

        /// <summary>
        /// Gets or sets the command that is executed when the profile item is tapped.
        /// </summary>
        public ICommand ProfileSelectedCommand { get; set; }

        #endregion

        #region Properties

        /// <summary>
        /// Gets or sets the interests collection.
        /// </summary>
        public ObservableCollection<ProfileModel> Interests
        {
            get
            {
                return this.interests;
            }

            set
            {
                this.interests = value;
                this.NotifyPropertyChanged();
            }
        }

        /// <summary>
        /// Gets or sets the connections collection.
        /// </summary>
        public ObservableCollection<ProfileModel> Connections
        {
            get
            {
                return this.connnections;
            }

            set
            {
                this.connnections = value;
                this.NotifyPropertyChanged();
            }
        }
       
        
       

      

     

        public string Photo
        {
            get
            {
                return this.photoUser;
            }

            set
            {
                if (this.photoUser != value)
                {
                    this.photoUser = value;
                    this.NotifyPropertyChanged();
                }
            }
        }

        public string name
        {
            get
            {
                return this.nameUser;
            }

            set
            {
                if (this.nameUser != value)
                {
                    this.nameUser = value;
                    this.NotifyPropertyChanged();
                }
            }
        }

        public string age
        {
            get
            {
                return this.ageUser;
            }

            set
            {
                if (this.ageUser != value)
                {
                    this.ageUser = value;
                    this.NotifyPropertyChanged();
                }
            }
        }

        public string chef
        {
            get
            {
                return this.chefUser;
            }

            set
            {
                if (this.chefUser != value)
                {
                    this.chefUser = value;
                    this.NotifyPropertyChanged();
                }
            }
        }


        public string email
        {
            get
            {
                return this.emailUser;
            }

            set
            {
                if (this.emailUser != value)
                {
                    this.emailUser = value;
                    this.NotifyPropertyChanged();
                }
            }
        }


        public string lastName
        {
            get
            {
                return this.lastNameUser;
            }

            set
            {
                if (this.lastNameUser != value)
                {
                    this.lastNameUser = value;
                    this.NotifyPropertyChanged();
                }
            }
        }


        public string password
        {
            get
            {
                return this.passwordUser;
            }

            set
            {
                if (this.passwordUser != value)
                {
                    this.passwordUser = value;
                    this.NotifyPropertyChanged();
                }
            }
        }


        /// <summary>
        /// Gets or sets the photos collection.
        /// </summary>
        public ObservableCollection<ProfileModel> Pictures
        {
            get
            {
                return this.pictures;
            }

            set
            {
                this.pictures = value;
                this.NotifyPropertyChanged();
            }
        }

        /// <summary>
        /// Gets or sets the header image path.
        /// </summary>
        public string HeaderImagePath
        {
            get { return App.BaseImageUrl + this.headerImagePath; }
            set { this.headerImagePath = value; }
        }

        /// <summary>
        /// Gets or sets the profile image.
        /// </summary>
        public string ProfileImage
        {
            get { return App.BaseImageUrl + this.profileImage; }
            set { this.profileImage = value; }
        }

        /// <summary>
        /// Gets or sets the background image.
        /// </summary>
        public string BackgroundImage
        {
            get { return App.BaseImageUrl + this.backgroundImage; }
            set { this.backgroundImage = value; }
        }

        /// <summary>
        /// Gets or sets the profile name
        /// </summary>
        public string ProfileName { get; set; }

        /// <summary>
        /// Gets or sets the designation
        /// </summary>
        public string Designation { get; set; }

        /// <summary>
        /// Gets or sets the state
        /// </summary>
        public string State { get; set; }

        /// <summary>
        /// Gets or sets the country
        /// </summary>
        public string Country { get; set; }

        /// <summary>
        /// Gets or sets the about
        /// </summary>
        public string About { get; set; }

        /// <summary>
        /// Gets or sets the posts count
        /// </summary>
        public int PostsCount { get; set; }

        /// <summary>
        /// Gets or sets the followers count
        /// </summary>
        public int FollowersCount { get; set; }

        /// <summary>
        /// Gets or sets the followings count
        /// </summary>
        public int FollowingCount { get; set; }

        #endregion

        #region Methods

        /// <summary>
        /// Invoked when the Follow button is clicked.
        /// </summary>
        /// <param name="obj">The Object</param>
        private void FollowClicked(object obj)
        {
            SfButton button = obj as SfButton;
            if (button.Text == "FOLLOW")
            {
                button.Text = "FOLLOWED";
            }
            else if (button.Text == "FOLLOWED")
            {
                button.Text = "FOLLOW";
            }
        }

        /// <summary>
        /// Invoked when the message button is clicked.
        /// </summary>
        /// <param name="obj">The Object</param>
        private void MessageClicked(object obj)
        {
            // Do something
        }

        /// <summary>
        /// Invoked when the AddConnection button is clicked.
        /// </summary>
        /// <param name="obj">The Object</param>
        private void AddConnectionClicked(object obj)
        {
            // Do something
        }

        /// <summary>
        /// Invoked when the Image is tapped.
        /// </summary>
        /// <param name="obj">The Object</param>
        private void ImageClicked(object obj)
        {
            // Do something
        }

        /// <summary>
        /// Invoked when the profile is tapped.
        /// </summary>
        /// <param name="obj">The Object</param>
        private void ProfileClicked(object obj)
        {
            // Do something
        }

        #endregion
    }
}
