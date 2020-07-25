using System;
using System.Collections.Generic;
using System.Text;

namespace CookTime.ViewModels
{
    public class Enterprise

    { 
            public string name { get; set; }
            public string logo { get; set; }
            public string contact { get; set; }
            public string schedule { get; set; }
            public string direction { get; set; }

        public string Logo
        {
            get
            {
                return App.BaseImageUrl + this.logo;
            }

            set
            {
                this.logo = value;
            }
        }
    }
}
