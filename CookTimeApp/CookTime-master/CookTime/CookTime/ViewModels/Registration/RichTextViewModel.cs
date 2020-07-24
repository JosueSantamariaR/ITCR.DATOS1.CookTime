using Sample;
using Syncfusion.XForms.RichTextEditor;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Runtime.CompilerServices;
using System.Text;
using System.Windows.Input;
using Xamarin.Forms;

namespace CookTime.ViewModels.Forms
{
    public class RichTextViewModel : INotifyPropertyChanged
    {
        
        public ICommand ImageInsertCommand { get; set; }

        public RichTextViewModel()
        {
            ImageInsertCommand = new Command<object>(Load);
        }

        void Load(object obj)
        {
            ImageInsertedEventArgs imageInsertedEventArgs = (obj as ImageInsertedEventArgs);
            this.GetImage(imageInsertedEventArgs);
        }

        async void GetImage(ImageInsertedEventArgs imageInsertedEventArgs)
        {
            Stream imageStream = await DependencyService.Get<IPhotoPickerService>().GetImageStreamAsync();
            Syncfusion.XForms.RichTextEditor.ImageSource imageSource = new Syncfusion.XForms.RichTextEditor.ImageSource();
            imageSource.ImageStream = imageStream;
            imageInsertedEventArgs.ImageSourceCollection.Add(imageSource);
        }

        public event PropertyChangedEventHandler PropertyChanged;


        public void RaisePropertyChange([CallerMemberName] string propertyname = null)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyname));
            }
        }





    }
}
