using CookTime.Views.Forms;
using Syncfusion.XForms.Buttons;
using System;
using System.Collections.ObjectModel;
using System.Net.Http;
using System.Windows.Input;
using Xamarin.Forms;
using Xamarin.Forms.Internals;
using ProfileModel = CookTime.Models.Profile;

namespace CookTime.ViewModels.Social
{
    /// <summary>
    /// ViewModel for social profile pages.
    /// </summary>
    [Preserve(AllMembers = true)]
    public class SocialProfileViewModel : BaseViewModel
    {
        #region Fields

        private ObservableCollection<ProfileModel> interests;

        private ObservableCollection<ProfileModel> connnections;

        private ObservableCollection<ProfileModel> pictures;

        private string headerImagePath;

        private string profileImage;

        private string backgroundImage;

        #endregion

        #region Constructor

        /// <summary>
        /// Initializes a new instance for the <see cref="SocialProfileViewModel" /> class.
        /// </summary>
        /// 
        static int followers = 0;
        static int following = 0;
        static SimpleLoginPage usercito = new SimpleLoginPage();
        static User user = usercito.GetUser();
        public SocialProfileViewModel()
        {
            //CallAPIsyncFollowers();
            //CallAPIsyncFollowing();
            this.HeaderImagePath = "Album2.png";
            this.ProfileImage = "ProfileImage3.png";
            this.BackgroundImage = "Sky-Image.png";
            this.ProfileName = user.name;
            this.Designation = "";
            this.State = "Contact: "+user.email;
            this.Country = "Edad: "+user.age;
            this.About = "Only a lover of the culinary world, with simple tastes and a great love for barbecues.";
            this.PostsCount = 8;
            this.FollowersCount = followers;
            this.FollowingCount = following;

            this.Pictures = new ObservableCollection<ProfileModel>()
            {
                new ProfileModel { ImagePath = "Recipe12.png" },
                new ProfileModel { ImagePath = "Recipe1.png" },
                new ProfileModel { ImagePath = "Recipe6.png" },
                new ProfileModel { ImagePath = "Recipe8.png" },
                new ProfileModel { ImagePath = "Recipe7.png" },
                new ProfileModel { ImagePath = "Recipe16.png" }

            };

            this.FollowCommand = new Command(this.FollowClicked);
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
        /*
        public void CallAPIsyncFollowers()
        {

            HttpClient client = new HttpClient();
            var endopoint = client.BaseAddress = new Uri($"http://192.168.1.102:8080/cooktime1/api/services/getUserFollowedName/{user.email}");
            var followed = client.GetAsync(endopoint).Result;
            if (followed.IsSuccessStatusCode)
            {
                var followersString = followed.Content.ReadAsStringAsync().Result;
                followers = Convert.ToInt32(followersString);
            }
        }
        public void CallAPIsyncFollowing()
        {
            HttpClient client = new HttpClient();
            var endopoint = client.BaseAddress = new Uri($"http://192.168.1.102:8080/cooktime1/api/services/getUserFollowedName/{user.email}");
            var followed = client.GetAsync(endopoint).Result;
            if (followed.IsSuccessStatusCode)
            {
                var followingString = followed.Content.ReadAsStringAsync().Result;
                following = Convert.ToInt32(followingString);

            }
        }*/

        #endregion
    }
}
