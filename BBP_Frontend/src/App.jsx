import {createBrowserRouter, createRoutesFromElements, Route, RouterProvider} from "react-router-dom";
import RootLayout from "./layouts/RootLayout.jsx";
import {ChakraProvider} from "@chakra-ui/react";
import Home from "./pages/user/Home.jsx";
import NotFound from "./pages/NotFound.jsx";
import ElementError from "./pages/ElementError.jsx";
import {DistrictProvider} from "./context/DistrictContext.jsx";
import AllClubs, {clubsLoader} from "./pages/user/AllClubs.jsx";
import ClubDetail, {clubLoader} from "./pages/user/ClubDetail.jsx";
import Auth from "./pages/Auth.jsx";
import {AuthProvider} from "./context/AuthProvider.jsx";
import Account, {userLoader} from "./pages/user/Account.jsx";
import RequireAuth from "./components/RequireAuth.jsx";
import Unauthorized from "./pages/Unauthorized.jsx";
import Find from "./pages/user/Find.jsx";

function App() {
    const ROLES = {
        'User': 0,
        'Staff': 1,
        'Admin': 2
    }

    const router = createBrowserRouter(
        createRoutesFromElements(
            <Route path="/" element={<RootLayout/>} errorElement={<ElementError/>}>
                <Route
                    index
                    element={<Home/>}
                    loader={clubsLoader}
                />

                <Route
                    path="clubs"
                    loader={clubsLoader}
                >
                    <Route index element={<AllClubs/>}/>
                    <Route path=":id" element={<ClubDetail/>} loader={clubLoader}/>
                </Route>

                <Route
                    path="find"
                    loader={clubsLoader}
                    element={<Find/>}
                />

                <Route
                    path="users"
                    element={<RequireAuth allowedRoles={"User"}/>}
                >
                    <Route path=":id" element={<Account/>} loader={userLoader}/>
                </Route>

                <Route path="auth" element={<Auth/>}/>

                <Route path="unauthorized" element={<Unauthorized/>}/>

                <Route path="*" element={<NotFound/>}/>
            </Route>
        )
    )

    return (
        <AuthProvider>
            <DistrictProvider>
                <ChakraProvider>
                    <RouterProvider router={router}/>
                </ChakraProvider>
            </DistrictProvider>
        </AuthProvider>
    )
}

export default App
