using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(EventManagement.Web.Startup))]
namespace EventManagement.Web
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
