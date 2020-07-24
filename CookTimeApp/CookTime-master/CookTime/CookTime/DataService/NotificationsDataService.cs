using System.Reflection;
using System.Runtime.Serialization.Json;
using CookTime.ViewModels.Notification;
using Xamarin.Forms.Internals;

namespace CookTime.DataService
{
    /// <summary>
    /// The Notification Data Service
    /// </summary>
    [Preserve(AllMembers = true)]
    public class NotificationsDataService
    {
        #region fields

        private static NotificationsDataService _instance;

        private SocialNotificationViewModel notificationViewModel;

        #endregion

        #region Properties

        /// <summary>
        /// Gets an instance of the <see cref="NotificationsDataService"/>.
        /// </summary>
        public static NotificationsDataService Instance => _instance ?? (_instance = new NotificationsDataService());

        /// <summary>
        /// Gets or sets the value of notification view model.
        /// </summary>
        public SocialNotificationViewModel SocialNotificationViewModel =>
            this.notificationViewModel ??
            (this.notificationViewModel = PopulateData<SocialNotificationViewModel>("notification.json"));

        #endregion

        #region Methods

        /// <summary>
        /// Populates the data for view model from json file.
        /// </summary>
        /// <typeparam name="T">Type of view model.</typeparam>
        /// <param name="fileName">Json file to fetch data.</param>
        /// <returns>Returns the view model object.</returns>
        private static T PopulateData<T>(string fileName)
        {
            var file = "CookTime.Data." + fileName;

            var assembly = typeof(App).GetTypeInfo().Assembly;

            T obj;

            using (var stream = assembly.GetManifestResourceStream(file))
            {
                var serializer = new DataContractJsonSerializer(typeof(T));
                obj = (T)serializer.ReadObject(stream);
            }

            return obj;
        }

        #endregion
    }
}
