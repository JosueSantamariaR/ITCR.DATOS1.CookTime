using System;
using System.Collections.Generic;
using System.Text;

namespace CookTime.ViewModels.News
{
    public class RecetList
    {
        public Recet[] recipes { get; set; }
    }
    
    public class Recet

    {
        public string photo { get; set; }
        public string name { get; set; }
        public string author { get; set; }
        public string type { get; set; }
        public string portions { get; set; }
        public string duration { get; set; }
        public string time { get; set; }
        public string difficulty { get; set; }
        public string dietTag { get; set; }
        
        public string ingredients { get; set; }
        public string steps { get; set; }
        public string price { get; set; }
        public string calification { get; set; }
        public string publication { get; set; }




        public string Photo
        {
            get
            {
                return App.BaseImageUrl + this.photo;
            }

            set
            {
                this.photo = value;
            }
        }
    }

}

