import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.PullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.pullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.2"

project {

    vcsRoot(HttpsGithubComAChubatovaPRrepo)

    buildType(B1ok2)
    buildType(B1ok3)
    buildType(B1ok4)
    buildType(B1ok)
    buildType(B2notok)
}

object B1ok : BuildType({
    name = "b1_ok"

    vcs {
        root(HttpsGithubComAChubatovaPRrepo)
    }

    features {
        pullRequests {
            enabled = false
            vcsRootExtId = "${HttpsGithubComAChubatovaPRrepo.id}"
            provider = github {
                authType = token {
                    token = "credentialsJSON:ca9153fc-02ce-4f9d-b2fb-4a83b487be95"
                }
                filterTargetBranch = "+:aasdasd"
                filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
            }
        }
    }
})

object B1ok2 : BuildType({
    name = "b1_ok2"

    vcs {
        root(HttpsGithubComAChubatovaPRrepo)
    }

    triggers {
        vcs {
        }
    }

    features {
        pullRequests {
            vcsRootExtId = "${HttpsGithubComAChubatovaPRrepo.id}"
            provider = github {
                authType = token {
                    token = "credentialsJSON:4235d8d2-aa7b-446a-8e65-adf041a6af65"
                }
                filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
            }
        }
    }
})

object B1ok3 : BuildType({
    name = "b1_ok3"

    vcs {
        root(HttpsGithubComAChubatovaPRrepo)
    }

    features {
        pullRequests {
            enabled = false
            vcsRootExtId = "${HttpsGithubComAChubatovaPRrepo.id}"
            provider = github {
                authType = token {
                    token = "credentialsJSON:ca9153fc-02ce-4f9d-b2fb-4a83b487be95"
                }
                filterTargetBranch = "+:aasdasd"
                filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
            }
        }
    }
})

object B1ok4 : BuildType({
    name = "b1_ok4"

    vcs {
        root(HttpsGithubComAChubatovaPRrepo)
    }

    features {
        pullRequests {
            enabled = false
            vcsRootExtId = "${HttpsGithubComAChubatovaPRrepo.id}"
            provider = github {
                authType = token {
                    token = "credentialsJSON:61129cde-2525-464a-9e91-f2428bb1be9a"
                }
                filterTargetBranch = "+:khkjhk"
                filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
            }
        }
    }
})

object B2notok : BuildType({
    name = "b2_notok"

    vcs {
        root(HttpsGithubComAChubatovaPRrepo)
    }

    features {
        pullRequests {
            enabled = false
            vcsRootExtId = "${HttpsGithubComAChubatovaPRrepo.id}"
            provider = github {
                authType = token {
                    token = "credentialsJSON:141743db-2023-4c4d-9919-df44ff5555bd"
                }
                filterTargetBranch = "+:refs/heads/skdj"
                filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
            }
        }
    }
})

object HttpsGithubComAChubatovaPRrepo : GitVcsRoot({
    name = "https://github.com/AChubatova/PRrepo"
    url = "https://github.com/AChubatova/PRrepo"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:4235d8d2-aa7b-446a-8e65-adf041a6af65"
    }
})
