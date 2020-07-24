using Xamarin.Forms.Internals;
using Xamarin.Forms.Xaml;

namespace CookTime.Views.Bookmarks
{
    /// <summary>
    /// Page to show article bookmark items
    /// </summary>
    [Preserve(AllMembers = true)]
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class BookmarksPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="BookmarksPage" /> class.
        /// </summary>
        public BookmarksPage()
        {
            InitializeComponent();
        }
    }
}