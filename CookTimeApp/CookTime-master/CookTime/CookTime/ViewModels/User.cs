using System;
using System.Collections.Generic;
using System.Text;

namespace CookTime.ViewModels
{
   
        public class User
        {
            public int age { get; set; }
            public bool chef { get; set; }
            public string email { get; set; }
            public string lastName { get; set; }
            public string name { get; set; }
            public string password { get; set; }
            public string photo { get; set; }


        public string Age
        {
            get
            {
                return Convert.ToString(this.age);
            }


        }

        public string Chef
        {
            get
            {
                if (this.chef == false)
                {
                    string x = "aficionado";
                    return x;
                }
                else
                {
                    string x = "chef";
                    return x;
                }
                
            }
        }

    }

    }

