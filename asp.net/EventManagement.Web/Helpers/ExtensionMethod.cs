using EventManagement.Domain.Entities;
using EventManagement.Web.Models;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace EventManagement.Helpers
{
    public static class ExtensionMethod
    {
        public static IEnumerable<SelectListItem>
            ToSelectListItems (this IEnumerable<user> numReal)
            {
            return numReal.OrderBy(c => c.firstName).Select(r =>
                   new SelectListItem
                   {
                       Text = r.firstName + " " +r.lastName,
                       Value = r.Id.ToString()

                    }
            
            );
            }
    }
}